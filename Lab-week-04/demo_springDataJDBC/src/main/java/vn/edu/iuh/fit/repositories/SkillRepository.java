/*
 * @ {#} SkillRepository.java   1.0     19/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.models.Skill;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   19/10/2024
 * @version:    1.0
 */
public interface SkillRepository {
    boolean insert(Skill skill);
    boolean update(Skill skill);
    boolean delete(Skill skill);
    Skill findById(Integer id);
    List<Skill> findAll();
    List<Skill> findByCandidateId(int id);
}
