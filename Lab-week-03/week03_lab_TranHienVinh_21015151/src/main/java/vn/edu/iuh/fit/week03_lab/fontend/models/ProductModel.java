/*
 * @ {#} ProductModel.java   1.0     02/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.week03_lab.fontend.models;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week03_lab.backend.responsitories.entities.Product;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   02/10/2024
 * @version:    1.0
 */
public class ProductModel {
    private final String ADD_URL = "http://localhost:8080/week03_lab-1.0-SNAPSHOT/api/products";

    public void createProduct(Product product) {
        try(Client client = ClientBuilder.newClient()) {
            WebTarget target = client.target(ADD_URL);

            Response response = target.request().post(Entity.json(product));
            if (response.getStatus() == Response.Status.CREATED.getStatusCode()) {
                System.out.println("Product added successfully");
            } else {
                System.out.println("Failed to add product");
            }
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
