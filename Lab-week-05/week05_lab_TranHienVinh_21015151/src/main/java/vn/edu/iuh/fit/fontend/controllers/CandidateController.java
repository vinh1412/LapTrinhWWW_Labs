/*
 * @ {#} CandidateController.java   1.0     06/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.fontend.controllers;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.backend.enums.SkillType;
import vn.edu.iuh.fit.backend.models.*;
import vn.edu.iuh.fit.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.backend.services.CandidateService;
import vn.edu.iuh.fit.backend.services.SkillService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   06/11/2024
 * @version:    1.0
 */
@Controller
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private SkillService skillService;

    @GetMapping("/list")
    public String showCandidateList(Model model) {
        model.addAttribute("candidates", candidateRepository.findAll());
        return "candidates/candidates";
    }
    @GetMapping("/candidates")
    public String showCandidateListPaging(Model model,
                                          @RequestParam("page") Optional<Integer> page,
                                          @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Candidate> candidatePage= candidateService.findAll(
                currentPage - 1,pageSize,"id","asc");
        model.addAttribute("candidatePage", candidatePage);
        int totalPages = candidatePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "candidates/candidates-paging";
    }
    @GetMapping("/signup")
    public String signupForm(Model model) {
        List<CountryCode> countries = List.of(CountryCode.values());
        List<Skill> skills = skillService.findAll();
        model.addAttribute("candidate", new Candidate());
        model.addAttribute("countries", countries);
        model.addAttribute("skills", skills);
        return "home/signup";
    }

    @PostMapping("/signup")
    public String createCandidate(@ModelAttribute Candidate candidate,
                                  @RequestParam List<Long> skillIds,
                                  @RequestParam List<Byte> skillLevels,
                                  @RequestParam(required = false) List<String> newSkillNames,
                                  @RequestParam(required = false) List<Byte> newSkillLevels,
                                  RedirectAttributes redirectAttributes) {
        // Kiểm tra số điện thoại đã tồn tại
        if (candidateService.existsByPhone(candidate.getPhone())) {
            redirectAttributes.addFlashAttribute("errorMessage", "Phone number already exists!");
            return "redirect:/signup"; // Quay lại trang đăng ký
        }

        // Kiểm tra email đã tồn tại
        if (candidateService.existsByEmail(candidate.getEmail())) {
            redirectAttributes.addFlashAttribute("errorMessage", "Email already exists!");
            return "redirect:/signup"; // Quay lại trang đăng ký
        }
        // Khởi tạo danh sách CandidateSkill nếu chưa có
        if (candidate.getCandidateSkills() == null) {
            candidate.setCandidateSkills(new ArrayList<>());
        }

        // Xử lý kỹ năng mới (nếu có)
        if (newSkillNames != null && !newSkillNames.isEmpty()) {
            for (int i = 0; i < newSkillNames.size(); i++) {
                String skillName = newSkillNames.get(i);
                Byte skillLevel = newSkillLevels != null ? newSkillLevels.get(i) : 1; // Nếu không có cấp độ, mặc định là 1

                if (skillName != null && !skillName.trim().isEmpty()) {
                    // Kiểm tra nếu kỹ năng chưa có trong cơ sở dữ liệu
                    Skill existingSkill = skillService.findBySkillName(skillName.trim());
                    Skill newSkill = null;

                    if (existingSkill == null) {
                        // Nếu kỹ năng chưa có, tạo mới
                        newSkill = new Skill();
                        newSkill.setSkillName(skillName);
                        newSkill.setSkillDescription("A programming language used for development of software.");
                        newSkill.setType(SkillType.SOFT_SKILL);
                        skillService.save(newSkill); // Lưu kỹ năng mới vào cơ sở dữ liệu
                    } else {
                        newSkill = existingSkill; // Nếu đã có, sử dụng kỹ năng hiện tại
                    }

                    // Tạo đối tượng CandidateSkill cho kỹ năng mới
                    CandidateSkill candidateSkill = new CandidateSkill();
                    CandidateSkillId candidateSkillId = new CandidateSkillId();
                    candidateSkillId.setCanId(candidate.getId());
                    candidateSkillId.setSkillId(newSkill.getId());
                    candidateSkill.setId(candidateSkillId);
                    candidateSkill.setCan(candidate);
                    candidateSkill.setSkill(newSkill);
                    candidateSkill.setSkillLevel(skillLevel);
                    candidateSkill.setMoreInfos("More info");

                    // Thêm vào danh sách CandidateSkill của Candidate
                    candidate.getCandidateSkills().add(candidateSkill);
                }
            }
        }

        // Lặp qua các kỹ năng đã có trong form và lưu chúng
        for (int i = 0; i < skillIds.size(); i++) {
            Long skillId = skillIds.get(i);
            Byte skillLevel = skillLevels.get(i);
            // Tìm Skill từ ID
            Skill skill = skillService.findById(skillId);
            // Tạo CandidateSkill cho kỹ năng đã chọn
            CandidateSkill candidateSkill = new CandidateSkill();
            CandidateSkillId candidateSkillId = new CandidateSkillId();
            candidateSkillId.setCanId(candidate.getId());
            candidateSkillId.setSkillId(skill.getId());
            candidateSkill.setId(candidateSkillId);
            candidateSkill.setCan(candidate);
            candidateSkill.setSkill(skill);
            candidateSkill.setSkillLevel(skillLevel);

            // Thêm vào danh sách CandidateSkill của Candidate
            candidate.getCandidateSkills().add(candidateSkill);
        }
        // Lưu đối tượng Candidate và CandidateSkill vào cơ sở dữ liệu
        candidateService.saveCandidate(candidate);
        redirectAttributes.addFlashAttribute("successMessage", "Candidate registered successfully!");
        return "redirect:/login";
    }



}
