/*
 * @ {#} QuanLyThuocRepository.java   1.0     23/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.entities.Thuoc;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   23/10/2024
 * @version:    1.0
 */
public class QuanLyThuocRepository {
    @PersistenceContext(unitName = "mariadb")
    private EntityManager em;
    public List<Thuoc> getDsThuoc() {
        return em.createNamedQuery("Thuoc.findAll", Thuoc.class).getResultList();
    }
    public Thuoc add(Thuoc thuoc) {
        em.persist(thuoc);
        return thuoc;
    }
}
