/*
 * @ {#} HomeController.java   1.0     12/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.fontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   12/11/2024
 * @version:    1.0
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String showIndex() {
        return "index";
    }
}
