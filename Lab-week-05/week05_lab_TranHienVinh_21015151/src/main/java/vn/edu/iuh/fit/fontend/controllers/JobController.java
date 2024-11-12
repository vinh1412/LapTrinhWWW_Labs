/*
 * @ {#} JobController.java   1.0     07/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.fontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.backend.dtos.JobDTO;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.Company;
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.models.JobSkill;
import vn.edu.iuh.fit.backend.services.*;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   07/11/2024
 * @version:    1.0
 */
@Controller
@RequestMapping("/jobs")
@SessionAttributes("email")
public class JobController {
    @Autowired
    private JobService jobService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private JobSkillService jobSkillService;
    @Autowired
    private CandidateServices candidateServices;

    @GetMapping("/list")
    public String showJobPostings(@ModelAttribute("email") String email, Model model) {
        Company company = companyService.findByEmail(email);
        List<Job> jobPostings = jobService.findByCompanyWithEmail(email);
        for (Job job : jobPostings) {
            List<JobSkill> jobSkills = jobSkillService.findByJob(job);
            job.setJobSkills(jobSkills);
        }
        model.addAttribute("company", company);
        model.addAttribute("jobPostings", jobPostings);
        return "jobs/dashboard-company";
    }

    @GetMapping("/new")
    public String showCreateJobForm(Model model) {
        model.addAttribute("jobDTO", new JobDTO());
        model.addAttribute("skills", skillService.findAll());
        model.addAttribute("companies", companyService.findAll());
        return "jobs/form";
    }

    @PostMapping("/save")
    public String saveJob(@ModelAttribute("jobDTO") JobDTO jobDTO) {
        jobService.save(jobDTO);
        return "redirect:/jobs"; // Điều hướng về trang danh sách sau khi lưu
    }

    @GetMapping("/details/{id}")
    public String getJobDetails(@PathVariable Long id, Model model) {
        Job job = jobService.findById(id);

        model.addAttribute("job", job);
        return "jobs/job-details";
    }

    @GetMapping("/recommendations")
    public String getJobRecommendations(@ModelAttribute("email") String email, Model model) {
        if (email != null) {
            List<Job> recommendedJobs = jobService.recommendJobsForCandidate(email);
            Candidate candidate = candidateServices.findByEmail(email);
            model.addAttribute("candidate", candidate);
            model.addAttribute("jobs", recommendedJobs);
            model.addAttribute("email", email);
            return "jobs/dashboard-candidate"; // Tên của trang Thymeleaf
        } else {
            return "redirect:/jobs/login";
        }
    }

    // Truy cập trang login
    @GetMapping("/login")
    public String login() {
        return "jobs/login"; // Trang login
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, Model model) {
        Candidate candidate = candidateServices.findByEmail(email);
        Company company = companyService.findByEmail(email);
        if (candidate != null) {
            model.addAttribute("email", email);
            return "redirect:/jobs/recommendations";
        }
        if (company != null) {
            model.addAttribute("email", email);
            return "redirect:/jobs/list";
        }
        model.addAttribute("error", "Không tìm thấy ứng viên hoặc công ty với email: " + email);
        return "jobs/login";

    }
}
