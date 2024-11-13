/*
 * @ {#} CandidateSkillRepository.java   1.0     12/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.CandidateSkill;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   12/11/2024
 * @version:    1.0
 */
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, Long> {
}
