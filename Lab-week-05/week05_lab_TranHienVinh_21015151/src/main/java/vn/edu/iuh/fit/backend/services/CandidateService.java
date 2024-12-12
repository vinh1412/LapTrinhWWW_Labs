/*
 * @ {#} CandidateServices.java   1.0     06/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.*;
import vn.edu.iuh.fit.backend.repositories.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   06/11/2024
 * @version:    1.0
 */
@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private ExperienceRepository experienceRepository;
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;
    @Autowired
    private SkillService skillService;

    public Page<Candidate> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return candidateRepository.findAll(pageable);
    }
    public Candidate findByEmail(String email) {
        return candidateRepository.findByEmail(email).orElse(null);
    }
    public List<Candidate> findCandidatesForJob(Job job) {
        List<Skill> requiredSkills = new ArrayList<>();
        // Lấy ra tất cả kỹ năng của công việc
        for (JobSkill jobSkill : job.getJobSkills()) {
            requiredSkills.add(jobSkill.getSkill());
        }
        return candidateRepository.findCandidatesWithSkills(requiredSkills);
    }

    public Candidate findById(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }
    public boolean existsByPhone(String phone) {
        return candidateRepository.existsByPhone(phone);
    }
    public boolean existsByEmail(String email) {
        return candidateRepository.existsByEmail(email);
    }
    public boolean existsByFullName(String fullName) {
        return candidateRepository.existsByFullName(fullName);
    }
    public void save(Candidate candidate) {
        Address address = candidate.getAddress();
        addressRepository.save(address);
        candidate.setAddress(address);
        candidateRepository.save(candidate);
    }
    public void saveCandidate(Candidate candidate) {
        Address address = candidate.getAddress();
        if (address != null) {
            addressRepository.save(address);
            candidate.setAddress(address);
            candidateRepository.save(candidate);
        }

        for (CandidateSkill candidateSkill : candidate.getCandidateSkills()) {
            Skill skill = candidateSkill.getSkill();

            if (skill.getId() == null || !skillRepository.existsById(skill.getId())) {
                skillRepository.save(skill);
            }
            CandidateSkillId id = new CandidateSkillId();
            id.setCanId(candidate.getId());
            id.setSkillId(skill.getId());

            candidateSkill.setId(id);
            candidateSkill.setCan(candidate);
            candidateSkill.setSkill(skill);
            System.out.println("Candidate: " + candidateSkill.getCan().getFullName());
            System.out.println("Skill: " + candidateSkill.getSkill().getSkillName());

            candidateSkillRepository.save(candidateSkill);
        }

        for (Experience experience : candidate.getExperiences()) {
            experience.setCandidate(candidate);
            experienceRepository.save(experience);
        }
        candidateRepository.save(candidate);
    }
    public void updateCandidate(Candidate candidate) {
        Address address = candidate.getAddress();
        if (address != null) {
            addressRepository.save(address);
            candidate.setAddress(address);
        }

        for (CandidateSkill candidateSkill : candidate.getCandidateSkills()) {
            Skill skill = candidateSkill.getSkill();

            if (skill.getId() == null || !skillRepository.existsById(skill.getId())) {
                skillRepository.save(skill);
            }
            CandidateSkillId id = new CandidateSkillId();
            id.setCanId(candidate.getId());
            id.setSkillId(skill.getId());

            candidateSkill.setId(id);
            candidateSkill.setCan(candidate);
            candidateSkill.setSkill(skill);
            System.out.println("Candidate: " + candidateSkill.getCan().getFullName());
            System.out.println("Skill: " + candidateSkill.getSkill().getSkillName());

            candidateSkillRepository.save(candidateSkill);
        }

        for (Experience experience : candidate.getExperiences()) {
            experience.setCandidate(candidate);
            experienceRepository.save(experience);
        }
        candidateRepository.save(candidate);
    }

    public void updateCandidateSkills(Candidate candidate, List<Long> skillIds, List<Byte> skillLevels,
                                      List<String> newSkillNames, List<Byte> newSkillLevels) {

        // Cập nhật các kỹ năng đã chọn
        for (int i = 0; i < skillIds.size(); i++) {
            Long skillId = skillIds.get(i);
            Byte skillLevel = skillLevels.get(i);
            Skill skill = skillService.findById(skillId);

            // Tìm kỹ năng hiện tại của candidate nếu có
            CandidateSkill existingCandidateSkill = candidateSkillRepository.findByCanIdAndSkillId(candidate.getId(), skill.getId());

            if (existingCandidateSkill != null) {
                // Cập nhật mức độ kỹ năng nếu có
                existingCandidateSkill.setSkillLevel(skillLevel);
                candidateSkillRepository.save(existingCandidateSkill); // Lưu lại thay đổi
            } else {
                // Nếu chưa có kỹ năng này, thêm mới
                CandidateSkill candidateSkill = new CandidateSkill();
                CandidateSkillId candidateSkillId = new CandidateSkillId();
                candidateSkillId.setCanId(candidate.getId());
                candidateSkillId.setSkillId(skill.getId());
                candidateSkill.setId(candidateSkillId);
                candidateSkill.setCan(candidate);
                candidateSkill.setSkill(skill);
                candidateSkill.setSkillLevel(skillLevel);

                candidate.getCandidateSkills().add(candidateSkill);
            }
        }

        // Thêm kỹ năng mới (nếu có)
        if (newSkillNames != null) {
            for (int i = 0; i < newSkillNames.size(); i++) {
                String skillName = newSkillNames.get(i);
                Byte skillLevel = (newSkillLevels != null && newSkillLevels.size() > i) ? newSkillLevels.get(i) : 1;

                Skill newSkill = skillService.findBySkillName(skillName.trim());
                if (newSkill == null) {
                    newSkill = new Skill();
                    newSkill.setSkillName(skillName);
                    skillService.save(newSkill);
                }

                CandidateSkill candidateSkill = new CandidateSkill();
                CandidateSkillId candidateSkillId = new CandidateSkillId();
                candidateSkillId.setCanId(candidate.getId());
                candidateSkillId.setSkillId(newSkill.getId());
                candidateSkill.setId(candidateSkillId);
                candidateSkill.setCan(candidate);
                candidateSkill.setSkill(newSkill);
                candidateSkill.setSkillLevel(skillLevel);

                candidate.getCandidateSkills().add(candidateSkill);
            }
        }
    }
}
