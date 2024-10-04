/*
 * @ {#} ProductDTO.java   1.0     05/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.week03_lab.backend.dtos;

import java.text.NumberFormat;
import java.util.Locale;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   05/10/2024
 * @version:    1.0
 */
public class ProductDTO {
    private int id;
    private String name;
    private String description;
    private String imgPath;
    private double price;

    public ProductDTO() {
    }

    public ProductDTO(int id, String name, String description, String imgPath, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgPath = imgPath;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getFormattedPrice() {
        Locale localeVN = new Locale("vi", "VN"); // For Vietnamese currency
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(localeVN);
        return currencyFormat.format(price);
    }
}
