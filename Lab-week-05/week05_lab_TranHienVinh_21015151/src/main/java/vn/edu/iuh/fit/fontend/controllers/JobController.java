/*
 * @ {#} JobController.java   1.0     07/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.fontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.edu.iuh.fit.backend.dtos.JobDTO;
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.models.JobSkill;
import vn.edu.iuh.fit.backend.services.CompanyService;
import vn.edu.iuh.fit.backend.services.JobService;
import vn.edu.iuh.fit.backend.services.JobSkillService;
import vn.edu.iuh.fit.backend.services.SkillService;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   07/11/2024
 * @version:    1.0
 */
@Controller
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService jobService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private JobSkillService jobSkillService;

    @GetMapping
    public String showJobPostings(Model model) {
        List<Job> jobPostings = jobService.findAll();
        for (Job job : jobPostings) {
            List<JobSkill> jobSkills = jobSkillService.findByJob(job);
            job.setJobSkills(jobSkills);
        }
        model.addAttribute("jobPostings", jobPostings);
        return "jobs/list";
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
}
