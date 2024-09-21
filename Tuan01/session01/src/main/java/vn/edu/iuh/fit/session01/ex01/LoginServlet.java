/*
 * @ {#} LoginServlet.java   1.0     27/08/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.session01.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.session01.ex01.beans.LoginBean;
import vn.edu.iuh.fit.session01.ex01.dao.AccountDao;
import vn.edu.iuh.fit.session01.ex01.dao.impl.AccountImpl;

import java.io.IOException;
import java.io.PrintWriter;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   27/08/2024
 * @version:    1.0
 */

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("us");
        String password = req.getParameter("psw");
//        LoginBean loginBean = new LoginBean();
        AccountDao accountDao = new AccountImpl();
        PrintWriter out = resp.getWriter();
        if (accountDao.checkLogin(username, password)) {
            out.println("Welcome " + username);
        } else {
            out.println("Login failed");
        }
    }
}
