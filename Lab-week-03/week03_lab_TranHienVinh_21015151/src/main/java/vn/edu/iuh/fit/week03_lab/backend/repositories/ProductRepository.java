/*
 * @ {#} ProductRepository.java   1.0     05/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.week03_lab.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.week03_lab.backend.repositories.entities.Product;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   05/10/2024
 * @version:    1.0
 */
public class ProductRepository {
    @PersistenceContext(unitName = "mariadb")
    private EntityManager em;
    public void add(Product product) {
        em.persist(product);
    }
    public List<Product> getAll() {
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }
    public Product getById(int id) {
        return em.createNamedQuery("Product.findById", Product.class).setParameter("id", id).getSingleResult();
    }
}
