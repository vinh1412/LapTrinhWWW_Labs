/*
 * @ {#} JobService.java   1.0     07/11/2024
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
import vn.edu.iuh.fit.backend.dtos.JobDTO;
import vn.edu.iuh.fit.backend.models.*;
import vn.edu.iuh.fit.backend.repositories.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   07/11/2024
 * @version:    1.0
 */
@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private JobSkillRepository jobSkillRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;
    public Page<Job> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return jobRepository.findAll(pageable);
    }
    public List<Job> findByCompanyWithEmail(String email) {
        return jobRepository.findJobsByCompany_Email(email);
    }
    public Page<Job> searchJobs(String search, Pageable pageable) {
        if (search == null || search.trim().isEmpty()) {
            return jobRepository.findAll(pageable);
        }
        return jobRepository.findByJobNameContainingIgnoreCaseOrCompany_CompNameContainingIgnoreCaseOrJobSkills_Skill_SkillNameContainingIgnoreCase(search, search, search, pageable);
    }

    public Job save(Job job) {
        return jobRepository.save(job);
    }

    public Job findById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }
    public List<Job> recommendJobsForCandidate(String email) {
        return jobRepository.findRecommendedJobsForCandidate(email);
    }
    public void deleteJobById(Long id) {
        jobRepository.deleteById(id);
    }
    public List<Job> searchJobs(String query, Long companyId) {
        return jobRepository.searchByJobNameOrSkillName(query, companyId);
    }
}
