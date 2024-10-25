/*
 * @ {#} QuanLyLoaiThuocRepository.java   1.0     23/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.core.Link;
import vn.edu.iuh.fit.entities.LoaiThuoc;
import vn.edu.iuh.fit.entities.Thuoc;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   23/10/2024
 * @version:    1.0
 */
public class QuanLyLoaiThuocRepository {
    @PersistenceContext(unitName = "mariadb")
    private EntityManager em;

    public List<LoaiThuoc> getDsLoaiThuoc() {
        return em.createNamedQuery("LoaiThuoc.findAll", LoaiThuoc.class).getResultList();
    }
    public List<Thuoc> getDsThuocByLoaiThuoc(int idLoaiThuoc) {
        return em.createNamedQuery("Thuoc.findByLoaiThuoc", Thuoc.class).setParameter("idLoaiThuoc", idLoaiThuoc).getResultList();
    }
}
