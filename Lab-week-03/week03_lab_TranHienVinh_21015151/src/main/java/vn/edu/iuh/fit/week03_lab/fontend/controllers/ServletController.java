/*
 * @ {#} ServletController.java   1.0     02/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.week03_lab.fontend.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week03_lab.backend.responsitories.entities.Product;
import vn.edu.iuh.fit.week03_lab.fontend.models.ProductModel;

import java.io.IOException;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   02/10/2024
 * @version:    1.0
 */
@WebServlet(name="ServletController", value = "/controller")
public class ServletController extends HttpServlet {
    @Inject
    private ProductModel productModel;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equals("add")){
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            String img_path = req.getParameter("img");

            Product product = new Product(name, description, img_path);
            productModel.createProduct(product);
            resp.sendRedirect("index.jsp");
        }
    }
}
