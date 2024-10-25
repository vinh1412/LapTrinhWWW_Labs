/*
 * @ {#} QuanLyThuocServlet.java   1.0     23/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.models.QuanLyLoaiThuocModel;
import vn.edu.iuh.fit.models.QuanLyThuocModel;

import java.io.IOException;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   23/10/2024
 * @version:    1.0
 */
@WebServlet(name = "QuanLyThuocServlet", urlPatterns = "/controller")
public class QuanLyThuocServlet extends HttpServlet {
    @Inject
    private QuanLyThuocModel quanLyThuocModel;
    @Inject
private QuanLyLoaiThuocModel quanLyLoaiThuocModel;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action==null || action.equals("listThuoc")){
            req.setAttribute("thuocs", quanLyThuocModel.getDsThuoc());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }else if (action.equals("listLoaiThuoc")){
            req.setAttribute("loaiThuocs", quanLyLoaiThuocModel.getDsLoaiThuoc());
            req.getRequestDispatcher("listLoaiThuoc.jsp").forward(req, resp);
        }else if (action.equals("listThuocByLoai")) {
            int idLoaiThuoc = Integer.parseInt(req.getParameter("idLoaiThuoc"));
            req.setAttribute("thuocs", quanLyLoaiThuocModel.getDsThuocByLoaiThuoc(idLoaiThuoc));
            req.setAttribute("loaiThuocs", quanLyLoaiThuocModel.getDsLoaiThuoc());
            req.getRequestDispatcher("listLoaiThuoc.jsp").forward(req, resp);
        }
    }
}
