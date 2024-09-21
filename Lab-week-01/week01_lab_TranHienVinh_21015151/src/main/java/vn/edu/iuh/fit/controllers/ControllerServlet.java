/*
 * @ {#} ControllerServlet.java   1.0     14/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.Log;
import vn.edu.iuh.fit.entities.Role;
import vn.edu.iuh.fit.services.AccountService;
import vn.edu.iuh.fit.services.LogService;
import vn.edu.iuh.fit.services.RoleService;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   14/09/2024
 * @version:    1.0
 */
@WebServlet(name = "controllerServlet", value = "/controller")
public class ControllerServlet extends HttpServlet {
    private AccountService accountServices;
    private RoleService roleServices;
    private LogService logServices;
    private ZoneId zoneId = ZoneId.of("Asia/Ho_Chi_Minh");

    public void init() {
        accountServices = new AccountService();
        roleServices = new RoleService();
        logServices = new LogService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String action = req.getParameter("action");
        if (action.equals("login")) {
            String accountId = req.getParameter("us");
            String passWord = req.getParameter("psw");
            boolean check = accountServices.checkLogin(accountId, passWord);
            if (check) {
                HttpSession session = req.getSession();
                session.setAttribute("accountId", accountId);
                Log log = new Log(accountId, Instant.now().atZone(zoneId).toInstant(), "login");
                logServices.addLog(log);
                session.setAttribute("log", log);
                resp.sendRedirect("dashboard.jsp");
            } else {
                req.setAttribute("error", "Invalid account or password");
                req.setAttribute("accountId", accountId);
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else if (action.equals("add")) {
            String accountId = req.getParameter("accountId");
            String fullName = req.getParameter("fullName");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String status = req.getParameter("status");
            Account account = new Account(accountId, fullName, password, email, phone, Byte.parseByte(status));
            if (accountServices.addAccount(account)) {
                resp.sendRedirect("dashboard.jsp");
            } else {
                req.setAttribute("error", "Add account failed");
                req.getRequestDispatcher("add.jsp").forward(req, resp);
            }
        } else if (action.equals("update")) {
            String accountId = req.getParameter("accountId");
            String fullName = req.getParameter("fullName");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String status = req.getParameter("status");
            Account account = new Account(accountId, fullName, password, email, phone, Byte.parseByte(status));
            if (accountServices.updateAccount(account)) {
                req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", "Update account failed");
                req.getRequestDispatcher("add.jsp").forward(req, resp);
            }
        } else if (action.equals("delete")) {
            String accountId = req.getParameter("accountId");
            if (accountId.equals(req.getSession().getAttribute("accountId"))) {
                req.setAttribute("error", "Can not delete current account");
                req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
            }
            Account account = accountServices.findAccountById(accountId);
            if (accountServices.deleteAccount(account)) {
                req.setAttribute("success", "Delete account success");
                req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", "Delete account failed");
                req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("add")){
            req.getRequestDispatcher("add.jsp").forward(req, resp);
        } else if (action.equals("update")) {
            req.getRequestDispatcher("add.jsp").forward(req, resp);
        } else if (action.equals("grantRole")) {
           String accountId = req.getParameter("accountId");
            if (roleServices.grantRole(accountId, "admin")) {
                req.setAttribute("success", "Grant role success");
                req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", "Grant role failed");
                req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
            }
        } else if (action.equals("filterByRole")) {
            String roleId = req.getParameter("roleId");
            List<Account> accounts =(roleId ==null || roleId.isEmpty()) ? accountServices.findAll() : accountServices.findAccountByRoleId(roleId);
            req.setAttribute("accounts", accounts);
            req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
        } else if (action.equals("logout")) {
            HttpSession session = req.getSession(false);
            if (session != null) {
                Log log = (Log) session.getAttribute("log");
                if (log != null) {
                    log.setLogoutTime(Instant.now().atZone(zoneId).toInstant());
                    logServices.addLog(log);
                }
                session.invalidate();
            }
            resp.sendRedirect("login.jsp");
        }
    }
}
