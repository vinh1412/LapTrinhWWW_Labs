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
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.fit.backend.models.Job;
import vn.edu.iuh.fit.backend.services.JobService;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   07/11/2024
 * @version:    1.0
 */
@Controller
public class JobController {
    @Autowired
    private JobService jobService;
    @GetMapping("/jobs")
    public String showJobPostings(Model model) {
        model.addAttribute("jobPostings", jobService.findAll());
        return "jobs/list";
    }

    @GetMapping("/jobs/new")
    public String showJobPostingForm(Model model) {
        model.addAttribute("jobPosting", new Job());
        return "jobs/form";
    }

    @PostMapping("/jobs")
    public String saveJobPosting(Job job) {
        jobService.save(job);
        return "redirect:/job-postings";
    }
}
