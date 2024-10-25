/*
 * @ {#} XeDAOImpl.java   1.0     25/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.Xe;
import vn.edu.iuh.fit.repositories.XeDAO;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   25/10/2024
 * @version:    1.0
 */
public class XeDAOImpl implements XeDAO {
    private EntityManager em;

    public XeDAOImpl() {
        this.em= Persistence.createEntityManagerFactory("mariadb").createEntityManager();
    }

    @Override
    public List<Xe> getDsXe() {
        String sql="select xe from Xe xe";
        return em.createQuery(sql, Xe.class).getResultList();
    }

    @Override
    public Xe findById(int idXe) {
        String sql="select xe from Xe xe where xe.id=:idXe";
        return em.createQuery(sql, Xe.class).setParameter("idXe",idXe).getSingleResult();
    }

    @Override
    public Xe findByName(String tenxe) {
        String sql="select xe from Xe xe where xe.tenxe=:tenxe";
        return em.createQuery(sql, Xe.class).setParameter("tenxe",tenxe).getSingleResult();
    }

    @Override
    public Xe addXe(Xe xe) {
        try {
            this.em.getTransaction().begin();
            this.em.persist(xe);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
        return xe;
    }

    @Override
    public Xe editXe(Xe xe) {
        try {
            this.em.getTransaction().begin();
            this.em.merge(xe);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
        return xe;
    }

    @Override
    public Xe deleteXe(Xe xe) {
        try {
            this.em.getTransaction().begin();
            this.em.remove(xe);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            this.em.getTransaction().rollback();
        }
        return xe;
    }
}
