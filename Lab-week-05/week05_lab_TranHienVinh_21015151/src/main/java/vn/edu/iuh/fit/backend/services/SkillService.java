/*
 * @ {#} SkillService.java   1.0     08/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.CandidateSkill;
import vn.edu.iuh.fit.backend.models.Skill;
import vn.edu.iuh.fit.backend.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.backend.repositories.SkillRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;
    public List<Skill> findAll() {
        return skillRepository.findAll().stream()
                .sorted(Comparator.comparing(Skill::getId))
                .limit(5)
                .collect(Collectors.toList());
    }
    public Skill findById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }
    public List<Skill> recommendSkillsForCandidate(Long candidateId) {
        Pageable pageable = PageRequest.of(0, 5);  // Lấy tối đa 5 kỹ năng
        return skillRepository.findSkillsNotInCandidateSkills(candidateId, pageable);
    }
    public void save(Skill skill) {
        skillRepository.save(skill);
    }
    public Skill findBySkillName(String skillName) {
        return skillRepository.findBySkillName(skillName);
    }
}
