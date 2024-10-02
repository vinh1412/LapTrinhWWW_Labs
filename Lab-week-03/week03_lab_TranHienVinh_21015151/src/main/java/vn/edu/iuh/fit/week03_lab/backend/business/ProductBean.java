/*
 * @ {#} ProductBean.java   1.0     02/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.week03_lab.backend.business;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.week03_lab.backend.responsitories.entities.Product;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   02/10/2024
 * @version:    1.0
 */
@Stateless
public class ProductBean implements ProductBeanRemote{
    @PersistenceContext(unitName = "mariadb")
    private EntityManager em;
    @Override
    public void add(Product product) {
        em.persist(product);
    }

    @Override
    public List<Product> getAll() {
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    @Override
    public Product getById(int id) {
        return em.createNamedQuery("Product.findById", Product.class).setParameter("id", id).getSingleResult();
    }
}
