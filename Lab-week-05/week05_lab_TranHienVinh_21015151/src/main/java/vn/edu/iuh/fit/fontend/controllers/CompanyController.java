/*
 * @ {#} CompanyController.java   1.0     29/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.fontend.controllers;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.backend.models.Company;
import vn.edu.iuh.fit.backend.services.CompanyService;

import java.util.Arrays;
import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   29/11/2024
 * @version:    1.0
 */
@Controller
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("company", new Company());

        // Load danh sách các quốc gia từ thư viện CountryCode
        List<CountryCode> countries = Arrays.asList(CountryCode.values());
        model.addAttribute("countries", countries);

        return "home/signUpCompany";
    }
    @PostMapping("/register")
    public String registerCompany(
            @ModelAttribute("company") Company company,
            RedirectAttributes redirectAttributes) {

        try {
            // Lưu thông tin công ty vào cơ sở dữ liệu
            companyService.save(company);

            // Thêm thông báo thành công
            redirectAttributes.addFlashAttribute("successMessage", "Company registered successfully!");

            // Chuyển hướng về trang chủ hoặc trang danh sách công ty
            return "redirect:/login";

        } catch (Exception e) {
            // Thêm thông báo lỗi nếu có vấn đề xảy ra
            redirectAttributes.addFlashAttribute("errorMessage", "Error occurred while registering the company: " + e.getMessage());

            // Quay lại trang đăng ký nếu có lỗi
            return "home/signUpCompany";
        }
    }

}
