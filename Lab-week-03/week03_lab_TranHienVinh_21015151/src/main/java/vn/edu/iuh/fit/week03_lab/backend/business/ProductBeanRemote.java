/*
 * @ {#} ProductBeanRemote.java   1.0     02/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.week03_lab.backend.business;

import jakarta.ejb.Remote;
import vn.edu.iuh.fit.week03_lab.backend.responsitories.entities.Product;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   02/10/2024
 * @version:    1.0
 */
@Remote
public interface ProductBeanRemote {
    void add (Product product);
    List<Product> getAll();
    Product getById(int id);
}
