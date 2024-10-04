/*
 * @ {#} ProductPriceRepository.java   1.0     05/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.week03_lab.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.week03_lab.backend.repositories.entities.ProductPrice;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   05/10/2024
 * @version:    1.0
 */
public class ProductPriceRepository {
    @PersistenceContext(unitName = "mariadb")
    private EntityManager em;

    public void add(ProductPrice productPrice) {
        em.persist(productPrice);
    }

    public List<ProductPrice> getAll() {
        return em.createNamedQuery("ProductPrice.findAll", ProductPrice.class).getResultList();
    }

    public ProductPrice getById(int id) {
        return em.createNamedQuery("ProductPrice.findById", ProductPrice.class).setParameter("id", id).getSingleResult();
    }

    public ProductPrice findActivePriceByProductId(int productId) {
        return em.createNamedQuery("ProductPrice.findActivePriceByProductId", ProductPrice.class).setParameter("productId", productId).getResultList().stream().findFirst().orElse(null);
    }
}
