/*
 * @ {#} SkillService.java   1.0     08/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Skill;
import vn.edu.iuh.fit.backend.repositories.SkillRepository;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   08/11/2024
 * @version:    1.0
 */
@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }
    public Skill findById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }
}
