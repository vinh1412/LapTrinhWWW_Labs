/*
 * @ {#} TestCandidateSkillRepository.java   1.0     19/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.models.CandidateSkill;
import vn.edu.iuh.fit.models.Skill;
import vn.edu.iuh.fit.repositories.impl.CandidateRepositoryImpl;
import vn.edu.iuh.fit.repositories.impl.SkillRepositoryImpl;

import javax.sql.DataSource;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   19/10/2024
 * @version:    1.0
 */
@SpringBootTest
public class TestCandidateSkillRepository {
    private CandidateSkillRepository candidateSkillRepository;
    private CandidateRepository candidateRepository;
    private SkillRepository skillRepository;
@Autowired
    public TestCandidateSkillRepository(CandidateSkillRepository candidateSkillRepository, DataSource dataSource) {
        this.candidateSkillRepository = candidateSkillRepository;
        this.candidateRepository = new CandidateRepositoryImpl(dataSource);
        this.skillRepository = new SkillRepositoryImpl(dataSource);
    }

    @Test
    void testInsert() {
        Candidate candidate = candidateRepository.findById(3);
        Skill skill = skillRepository.findById(6);
         CandidateSkill candidateSkill = new CandidateSkill();
        candidateSkill.setCandidate(candidate);
        candidateSkill.setSkill(skill);
        candidateSkill.setLevel(5);
        boolean result = candidateSkillRepository.insert(candidateSkill);
        Assertions.assertEquals(true, result);
    }
    @Test
    void testUpdate() {
        Candidate candidate = candidateRepository.findById(3);
        Skill skill = skillRepository.findById(6);
        CandidateSkill candidateSkill = new CandidateSkill();
        candidateSkill.setCandidate(candidate);
        candidateSkill.setSkill(skill);
        candidateSkill.setLevel(1);
        boolean result = candidateSkillRepository.update(candidateSkill);
        Assertions.assertEquals(true, result);
    }
    @Test
    void testDelete() {
        Candidate candidate = candidateRepository.findById(3);
        Skill skill = skillRepository.findById(6);
        CandidateSkill candidateSkill = new CandidateSkill();
        candidateSkill.setCandidate(candidate);
        candidateSkill.setSkill(skill);
        boolean result = candidateSkillRepository.delete(candidateSkill);
        Assertions.assertEquals(true, result);
    }
}
