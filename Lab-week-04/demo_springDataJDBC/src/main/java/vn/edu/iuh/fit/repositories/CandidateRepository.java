/*
 * @ {#} CandidateDAO.java   1.0     17/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories;

import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Candidate;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   17/10/2024
 * @version:    1.0
 */

public interface CandidateRepository {
    boolean insert(Candidate candidate);
    boolean update(Candidate candidate);
    boolean delete(Candidate candidate);
    Candidate findById(int id);
    List<Candidate> findAll();
    List<Candidate> findBySkillId(int id);
}
