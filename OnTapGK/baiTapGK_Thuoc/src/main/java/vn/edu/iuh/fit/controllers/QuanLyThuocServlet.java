/*
 * @ {#} QuanLyThuocServlet.java   1.0     24/10/2024
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
import vn.edu.iuh.fit.entities.Loaithuoc;
import vn.edu.iuh.fit.entities.Thuoc;
import vn.edu.iuh.fit.services.QuanLyThuocService;
import vn.edu.iuh.fit.services.impl.QuanLyThuocServiceImpl;

import java.io.IOException;
import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   24/10/2024
 * @version:    1.0
 */
@WebServlet(name = "QuanLyThuocServlet", urlPatterns = "/controller")
public class QuanLyThuocServlet extends HttpServlet {
    private QuanLyThuocService quanLyThuocService;

    public void init() {
        quanLyThuocService = new QuanLyThuocServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("danhSachThuoc")) {
            List<Thuoc> thuocs = quanLyThuocService.getAll();
            req.setAttribute("danhSachThuoc", thuocs);
            req.getRequestDispatcher("danhSachThuoc.jsp").forward(req, resp);
        } else if (action.equals("danhSachLoaiThuoc")) {
            req.setAttribute("danhSachLoaiThuoc", quanLyThuocService.getAllLoaiThuoc());
            req.getRequestDispatcher("danhSachLoaiThuoc.jsp").forward(req, resp);
        } else if (action.equals("listThuocByLoai")) {
            int idLoaiThuoc = Integer.parseInt(req.getParameter("idLoaiThuoc"));
            if (idLoaiThuoc == 0) {
                req.setAttribute("thuocs", quanLyThuocService.getAll());
            } else {
                req.setAttribute("thuocs", quanLyThuocService.getListThuocByLoai(idLoaiThuoc));
            }
            req.setAttribute("idLoaiThuoc", idLoaiThuoc);
            req.setAttribute("danhSachLoaiThuoc", quanLyThuocService.getAllLoaiThuoc()); //hiển thị lại danh sách loại thuốc
            req.getRequestDispatcher("danhSachLoaiThuoc.jsp").forward(req, resp);
        } else if (action.equals("themThuoc")) {
            req.setAttribute("danhSachLoaiThuoc", quanLyThuocService.getAllLoaiThuoc());
            req.getRequestDispatcher("addThuoc.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("themThuoc")) {
            Thuoc thuoc = new Thuoc();
            thuoc.setTenthuoc(req.getParameter("name"));
            thuoc.setGia(Double.parseDouble(req.getParameter("price")));
            thuoc.setNamsx(Integer.parseInt(req.getParameter("namSX")));
            String loaiThuoc = req.getParameter("idLoaiThuoc");
            Loaithuoc loaithuoc = quanLyThuocService.getById(Integer.parseInt(loaiThuoc));
            thuoc.setMaloai(loaithuoc);

            quanLyThuocService.save(thuoc);
            resp.sendRedirect("controller?action=danhSachThuoc");
        }
    }
}
