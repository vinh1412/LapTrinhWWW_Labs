/*
 * @ {#} TestCandidateRepositories.java   1.0     17/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.models.Candidate;

import java.time.LocalDate;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   17/10/2024
 * @version:    1.0
 */
@SpringBootTest
public class TestCandidateRepository {
    private CandidateRepository candidateRepository;

    @Autowired
    public TestCandidateRepository(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }
    @Test
    void testInsert() {
        Candidate candidate = new Candidate();
        candidate.setFullName("Tran Hien Vinh1");
        candidate.setDob(LocalDate.of(2001, 12, 11));
        candidate.setAddress("Ho Chi Minh City1");
        candidate.setPhone("056445566");
        candidate.setEmail("vinh1@gmail.com");

        boolean result = candidateRepository.insert(candidate);
        Assertions.assertEquals(true, result);
    }
    @Test
    void testUpdate() {
        Candidate candidate = new Candidate();
        candidate.setId(2);
        candidate.setFullName("Tran Hien Vinh1");
        candidate.setDob(LocalDate.of(2002, 12, 11));
        candidate.setAddress("Ho Chi Minh City1");
        candidate.setPhone("0564455661");
        candidate.setEmail("vinh1@gmai.com");
        boolean result = candidateRepository.update(candidate);
        Assertions.assertEquals(true, result);
    }
    @Test
    void testDelete() {
        Candidate candidate = new Candidate();
        candidate.setId(1);
        boolean result = candidateRepository.delete(candidate);
        Assertions.assertEquals(true, result);
    }

    @Test
    void testFindById() {
        Candidate candidate = candidateRepository.findById(3);
        Assertions.assertEquals(3, candidate.getId());
    }

    @Test
    void testFindAll() {
        Assertions.assertEquals(2, candidateRepository.findAll().size());
    }
    @Test
    void testFindBySkillId() {
        Assertions.assertEquals(2, candidateRepository.findBySkillId(7).size());
    }
}
