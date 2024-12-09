/*
 * @ {#} JobController.java   1.0     07/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.fontend.controllers;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.backend.converters.SkillLevelConverter;
import vn.edu.iuh.fit.backend.enums.SkillLevel;
import vn.edu.iuh.fit.backend.enums.SkillType;
import vn.edu.iuh.fit.backend.models.*;
import vn.edu.iuh.fit.backend.services.*;

import java.util.*;
import java.util.stream.Collectors;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   07/11/2024
 * @version:    1.0
 */
@Controller
@RequestMapping("/jobs")
//@SessionAttributes("email")
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
    private CandidateService candidateService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private JobApplicationService jobApplicationService;

    // Hiển thị danh sách công việc của công ty
    @GetMapping("/list")
    public String showJobPostings(@SessionAttribute("email") String email, Model model) {
        Company company = companyService.findByEmail(email);
        List<Job> jobPostings = jobService.findByCompanyWithEmail(email);
        for (Job job : jobPostings) {
            List<JobSkill> jobSkills = jobSkillService.findByJob(job);
            job.setJobSkills(jobSkills);
        }
        model.addAttribute("company", company);
        model.addAttribute("jobPostings", jobPostings);
        return "companies/dashboard-company";
    }

    // Hiển thị form tạo mới công việc
    @GetMapping("/new")
    public String showCreateJobForm(@SessionAttribute("email") String email, Model model) {
        Company company = companyService.findByEmail(email);
        Job job = new Job();
        job.setCompany(company);
        job.setJobSkills(new ArrayList<>());
        model.addAttribute("job", job);
        model.addAttribute("skills", skillService.findAll());
        model.addAttribute("company", company);
        return "jobs/form-add-job";
    }

    // Lưu công việc mới
    @PostMapping("/save")
    public String saveJob(@ModelAttribute("job") Job job,
                          @RequestParam(value = "newSkillNames", required = false) List<String> newSkillNames,
                          @RequestParam(value = "newSkillLevels", required = false) List<Byte> newSkillLevels,
                          @RequestParam(value = "newSkillMoreInfos", required = false) List<String> newSkillMoreInfos) {
        if (job.getJobSkills() == null) {
            job.setJobSkills(new ArrayList<>());
        }

        // Xử lý kỹ năng mới được nhập
        if (newSkillNames != null && newSkillLevels != null) {
            for (int i = 0; i < newSkillNames.size(); i++) {
                String skillName = newSkillNames.get(i).trim();
                Byte skillLevelByte  = newSkillLevels != null ? newSkillLevels.get(i) : 1;
                SkillLevelConverter converter = new SkillLevelConverter();
                SkillLevel skillLevel = converter.convertToEntityAttribute(skillLevelByte);
                String moreInfo = (newSkillMoreInfos != null && newSkillMoreInfos.size() > i)
                        ? newSkillMoreInfos.get(i).trim()
                        : "";

                if (!skillName.isEmpty()) {
                    // Tìm kỹ năng trong cơ sở dữ liệu, nếu chưa tồn tại thì thêm mới
                    Skill skill = skillService.findBySkillName(skillName);
                    if (skill == null) {
                        skill = new Skill();
                        skill.setSkillName(skillName);
                        skill.setSkillDescription("A programming language used for development of software.");
                        skill.setType(SkillType.SOFT_SKILL);
                        skillService.save(skill);
                    }
                    // Tạo JobSkill mới từ kỹ năng và thêm vào danh sách
                    JobSkill jobSkill = new JobSkill();
                    jobSkill.setSkill(skill);
                    jobSkill.setSkillLevel(skillLevel);
                    jobSkill.setMoreInfos(moreInfo);
                    jobSkill.setJob(job);

                    job.getJobSkills().add(jobSkill);
                }
            }
        }

        job.getJobSkills().removeIf(jobSkill -> jobSkill.getSkill() == null || jobSkill.getSkillLevel() == null);
        jobService.save(job);
        for (JobSkill jobSkill : job.getJobSkills()) {
            if (jobSkill.getSkill() != null && jobSkill.getSkillLevel() != null) {
                jobSkill.setJob(job);
                jobSkillService.save(jobSkill);
            }
        }
        return "redirect:/jobs/list"; // Chuyển hướng tới trang danh sách công việc
    }

    // Hiển thị chi tiết công việc
    @GetMapping("/details/{id}")
    public String getJobDetails(@PathVariable Long id, Model model) {
        Job job = jobService.findById(id);

        model.addAttribute("job", job);
        return "jobs/job-details";
    }

    // Hiển thị danh sách công việc được đề xuất cho ứng viên
    @GetMapping("/recommendations")
    public String getJobRecommendations(@SessionAttribute("email") String email, Model model) {
        if (email != null) {
            List<Job> recommendedJobs = jobService.recommendJobsForCandidate(email);
            Candidate candidate = candidateService.findByEmail(email);
            model.addAttribute("candidate", candidate);
            model.addAttribute("jobs", recommendedJobs);
            model.addAttribute("email", email);
            return "candidates/dashboard-candidate";
        } else {
            return "redirect:/login";
        }
    }

    // Hiển thị form mời ứng viên ứng tuyển
    @GetMapping("/{jobId}/invite")
    public String showCandidatesForJob(@PathVariable Long jobId, Model model) {
        Job job = jobService.findById(jobId);
        List<Candidate> candidates = candidateService.findCandidatesForJob(job);
        model.addAttribute("job", job);
        model.addAttribute("candidates", candidates);
        return "jobs/invite-candidates";
    }

    // Xử lý mời ứng viên ứng tuyển
    @PostMapping("/{jobId}/inviteCandidate/{candidateId}")
    public String inviteCandidate(@PathVariable Long jobId, @PathVariable Long candidateId, RedirectAttributes redirectAttributes) {
        Candidate candidate = candidateService.findById(candidateId);
        if (candidate == null) {
            throw new RuntimeException("Candidate not found");
        }

        Job job = jobService.findById(jobId);
        if (job == null) {
            throw new RuntimeException("Job not found");
        }

        String toEmail = candidate.getEmail();
        String subject = "Job Invitation for " + job.getJobName();
        String body = "Dear " + candidate.getFullName() + ",\n\n" +
                "We are excited to invite you to apply for the position of " + job.getJobName() + " at our company. " +
                "This role requires the following skills: " + job.getJobSkills().stream()
                .map(skill -> skill.getSkill().getSkillName())
                .collect(Collectors.joining(", ")) + ".\n\n" +
                "Please let us know if you're interested.\n\nBest regards,\n" + job.getCompany().getCompName();

        emailService.sendInvitationEmail(toEmail, subject, body);
        redirectAttributes.addFlashAttribute("successMessage", "Invitation email sent successfully to " + candidate.getFullName());
        return "redirect:/jobs/" + jobId + "/invite";
    }

    // Xử lý xóa công việc
    @PostMapping("/{id}/delete")
    public String deleteJob(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            jobService.deleteJobById(id);
            //
            redirectAttributes.addFlashAttribute("successMessage", "Job deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to delete job.");
        }
        return "redirect:/jobs/list";
    }

    // Hiển thị form chỉnh sửa công việc
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        // Tìm kiếm công việc theo ID
        Job job = jobService.findById(id);
        List<Skill> skills = job.getJobSkills().stream()
                .map(JobSkill::getSkill)
                .collect(Collectors.toList());
        System.out.println("jobSkills:");
        for (JobSkill jobSkill : job.getJobSkills()) {
            System.out.println("  JobSkill ID: " + jobSkill.getSkill().getId() + ", Skill Name: " + jobSkill.getSkill().getSkillName());
        }

        System.out.println("skills:");
        for (Skill skill : skills) {
            System.out.println("  Skill ID: " + skill.getId() + ", Skill Name: " + skill.getSkillName());
        }
        if (job != null) {
            if (job.getJobSkills() == null) {
                job.setJobSkills(new ArrayList<>());
            }
            List<Long> selectedSkillIds = job.getJobSkills().stream()
                    .map(jobSkill -> jobSkill.getSkill().getId())
                    .collect(Collectors.toList());
            model.addAttribute("selectedSkillIds", selectedSkillIds);
            model.addAttribute("job", job);
            model.addAttribute("skills", skills);
            return "jobs/form-edit-job";
        } else {
            return "redirect:/jobs/list";
        }
    }

    //  Xử lý cập nhật công việc
    @PostMapping("/{id}/edit")
    public String updateJob(@PathVariable("id") Long id, @ModelAttribute("job") Job job, RedirectAttributes redirectAttributes) {
        // Tìm job theo id và kiểm tra xem có tồn tại hay không
        Job existingJob = jobService.findById(id); // Giả sử jobService có phương thức này

        if (existingJob == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Job not found!");
            return "redirect:/jobs/list";
        }

        // Cập nhật các thuộc tính của job
        existingJob.setJobName(job.getJobName());
        existingJob.setJobDesc(job.getJobDesc());
        existingJob.setCompany(job.getCompany());
        // Các thuộc tính khác của Job...

        // Nếu jobSkills là null, khởi tạo mới
        if (job.getJobSkills() == null) {
            job.setJobSkills(new ArrayList<>());
        }

        // Xử lý jobSkills
        job.getJobSkills().removeIf(jobSkill -> jobSkill.getSkill() == null || jobSkill.getSkillLevel() == null);
        for (JobSkill jobSkill : job.getJobSkills()) {
            if (jobSkill.getSkill() != null && jobSkill.getSkillLevel() != null) {
                jobSkill.setJob(existingJob); // Liên kết JobSkill với Job
                jobSkillService.save(jobSkill); // Lưu JobSkill
            }
        }

        // Lưu lại job sau khi cập nhật
        jobService.save(existingJob);
        redirectAttributes.addFlashAttribute("successMessage", "Job updated successfully!");
        return "redirect:/jobs/list";
    }
    @GetMapping("/search")
    public String searchJobs(
            @RequestParam("query") String query,
            @RequestParam("companyId") Long companyId,
            Model model) {

        Company company = companyService.findById(companyId);
        model.addAttribute("company", company);
        List<Job> jobPostings = jobService.searchJobs(query, companyId);
        model.addAttribute("jobPostings", jobPostings);
        model.addAttribute("query", query);
        return "companies/dashboard-company";
    }
    @GetMapping("/apply/{id}")
    public String showApplicationForm(@PathVariable Long id, @SessionAttribute("email") String email, Model model) {
        Job job = jobService.findById(id);
        model.addAttribute("job", job);
        model.addAttribute("jobId", id);
        Candidate candidate = candidateService.findByEmail(email);
        model.addAttribute("candidate", candidate);
        return "candidates/apply";
    }

    @PostMapping("apply/sendApply")
    public String submitApplication(@RequestParam String jobId,
                                    @RequestParam String applicantName,
                                    @RequestParam String email,
                                    @RequestParam String message,
                                    RedirectAttributes redirectAttributes) {
        try {
            // Retrieve the job based on the jobId
            Job job = jobService.findById(Long.parseLong(jobId));

            // Optionally, retrieve the candidate based on their email or other attributes
            Candidate candidate = candidateService.findByEmail(email);
            if (candidate == null) {
                redirectAttributes.addFlashAttribute("errorMessage", "Candidate not found.");
                return "redirect:/jobs/apply/" + jobId;
            }

            // Send the application with detailed candidate information
            jobApplicationService.sendApplication(jobId, applicantName, email, message, job, candidate);

            redirectAttributes.addFlashAttribute("successMessage", "Your application has been sent successfully!");
        } catch (MessagingException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "There was an error sending your application.");
        }
        return "redirect:/jobs/apply/" + jobId;
    }

}
