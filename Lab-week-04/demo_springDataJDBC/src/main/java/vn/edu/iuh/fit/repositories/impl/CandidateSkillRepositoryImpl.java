/*
 * @ {#} CandidateSkillRepositoryImpl.java   1.0     19/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.CandidateSkill;
import vn.edu.iuh.fit.repositories.CandidateRepository;
import vn.edu.iuh.fit.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.repositories.SkillRepository;

import javax.sql.DataSource;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   19/10/2024
 * @version:    1.0
 */
@Repository
public class CandidateSkillRepositoryImpl implements CandidateSkillRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private CandidateRepository candidateRepository;
    private SkillRepository skillRepository;

    @Autowired
    public CandidateSkillRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.candidateRepository = new CandidateRepositoryImpl(dataSource);
        this.skillRepository = new SkillRepositoryImpl(dataSource);
    }

    @Override
    public boolean insert(CandidateSkill candidateSkill) {
        String sql = "INSERT INTO candidate_skill(candidate_id, skill_id, skill_level) VALUES(?, ?, ?)";
        if (candidateRepository.findById(candidateSkill.getCandidate().getId()) == null) {
            return false;
        }
        if (skillRepository.findById(candidateSkill.getSkill().getId()) == null) {
            return false;
        }
        return jdbcTemplate.update(sql, candidateSkill.getCandidate().getId(), candidateSkill.getSkill().getId(), candidateSkill.getLevel()) > 0;
    }

    @Override
    public boolean update(CandidateSkill candidateSkill) {
        String sql = "UPDATE candidate_skill SET skill_level = ? WHERE candidate_id = ? AND skill_id = ?";
        if (candidateRepository.findById(candidateSkill.getCandidate().getId()) == null) {
            return false;
        }
        if (skillRepository.findById(candidateSkill.getSkill().getId()) == null) {
            return false;
        }
        return jdbcTemplate.update(sql, candidateSkill.getLevel(), candidateSkill.getCandidate().getId(), candidateSkill.getSkill().getId()) > 0;
    }

    @Override
    public boolean delete(CandidateSkill candidateSkill) {
        String sql = "DELETE FROM candidate_skill WHERE candidate_id = ? AND skill_id = ?";
        if (candidateRepository.findById(candidateSkill.getCandidate().getId()) == null) {
            return false;
        }
        if (skillRepository.findById(candidateSkill.getSkill().getId()) == null) {
            return false;
        }
        return jdbcTemplate.update(sql, candidateSkill.getCandidate().getId(), candidateSkill.getSkill().getId()) > 0;
    }
}
