/*
 * @ {#} CandidateSkillRepository.java   1.0     19/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.CandidateSkill;
import vn.edu.iuh.fit.models.Skill;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   19/10/2024
 * @version:    1.0
 */
public interface CandidateSkillRepository {
    boolean insert(CandidateSkill candidateSkill);
    boolean update(CandidateSkill candidateSkill);
    boolean delete(CandidateSkill candidateSkill);

}
