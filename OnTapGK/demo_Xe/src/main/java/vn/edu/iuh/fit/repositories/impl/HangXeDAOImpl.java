/*
 * @ {#} HangXeDAOImpl.java   1.0     25/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.HangXe;
import vn.edu.iuh.fit.repositories.HangXeDAO;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   25/10/2024
 * @version:    1.0
 */
public class HangXeDAOImpl implements HangXeDAO {
    private EntityManager em;

    public HangXeDAOImpl() {
        this.em= Persistence.createEntityManagerFactory("mariadb").createEntityManager();
    }

    @Override
    public List<HangXe> getDsHangXe() {
        String sql="select hx from HangXe hx";
        return em.createQuery(sql, HangXe.class).getResultList();
    }

    @Override
    public HangXe findById(int maHangxe) {
        String sql="select hx from HangXe hx where hx.id=:maHangxe";
        return em.createQuery(sql, HangXe.class).setParameter("maHangxe", maHangxe).getSingleResult();
    }
}
