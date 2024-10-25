/*
 * @ {#} CuahangxemayABCServlet.java   1.0     25/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entities.HangXe;
import vn.edu.iuh.fit.entities.Xe;
import vn.edu.iuh.fit.services.HangXeService;
import vn.edu.iuh.fit.services.XeService;
import vn.edu.iuh.fit.services.impl.HangXeServiceImpl;
import vn.edu.iuh.fit.services.impl.XeServiceImpl;

import java.io.IOException;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   25/10/2024
 * @version:    1.0
 */
@WebServlet(name = "CuahangxemayABCServlet", urlPatterns = "/controller")
public class CuahangxemayABCServlet extends HttpServlet {
    private XeService xeService;
    private HangXeService hangXeService;

    public CuahangxemayABCServlet() {
        this.xeService=new XeServiceImpl();
        this.hangXeService=new HangXeServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if(action==null || action.equalsIgnoreCase("dsXe")){
            req.setAttribute("dsXe", xeService.getDsXe());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else if (action.equalsIgnoreCase("findByName")) {
            String name=req.getParameter("nameXe");
            req.setAttribute("dsXe", xeService.findByName(name));
            req.getRequestDispatcher("danhSachXe.jsp").forward(req,resp);
        } else if (action.equalsIgnoreCase("addXe")) {
            req.setAttribute("dsHangXe", hangXeService.getDsHangXe());
            req.getRequestDispatcher("form.jsp").forward(req,resp);
        }else if (action.equalsIgnoreCase("editXe")) {
            int idXe=Integer.parseInt(req.getParameter("id"));
            Xe xe=xeService.findById(idXe);
            req.setAttribute("xe", xe);
            req.setAttribute("dsHangXe", hangXeService.getDsHangXe());
            req.getRequestDispatcher("form.jsp").forward(req,resp);
        }else if (action.equalsIgnoreCase("deleteXe")) {
            int idXe=Integer.parseInt(req.getParameter("id"));
            Xe xe=xeService.findById(idXe);
            xeService.deleteXe(xe);
            resp.sendRedirect("controller?action=dsXe");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        String tenXe=req.getParameter("tenXe");
        double giaXe=Double.parseDouble(req.getParameter("giaXe"));
        int namSX=Integer.parseInt(req.getParameter("namSanXuat"));
        int idHangXe=Integer.parseInt(req.getParameter("maHangXe"));
        if (action.equalsIgnoreCase("addXe")){
            Xe xe=new Xe();
            xe.setTenxe(tenXe);
            xe.setGiaxe(giaXe);
            xe.setNamsanxuat(namSX);
            HangXe hangXe=hangXeService.findById(idHangXe);
            xe.setMahangxe(hangXe);
            Xe x=xeService.addXe(xe);
            if (x!=null) {
                resp.sendRedirect("controller?action=dsXe");
            } else {
                req.setAttribute("message", "Thêm xe không thành công");
                req.getRequestDispatcher("form.jsp").forward(req, resp);
            }
        }else if (action.equalsIgnoreCase("editXe")){
            String idStr=req.getParameter("id");
            if (idStr!=null && !idStr.isEmpty()){
                int id=Integer.parseInt(idStr);
                Xe xe=xeService.findById(id);
                xe.setTenxe(tenXe);
                xe.setGiaxe(giaXe);
                xe.setNamsanxuat(namSX);
                xe.setMahangxe(hangXeService.findById(idHangXe));
                Xe x=xeService.editXe(xe);
                if (x!=null) {
                    resp.sendRedirect("controller?action=dsXe");
                } else {
                    req.setAttribute("message", "Edit xe không thành công");
                    req.getRequestDispatcher("form.jsp").forward(req, resp);
                }
            }
        }
    }
}
