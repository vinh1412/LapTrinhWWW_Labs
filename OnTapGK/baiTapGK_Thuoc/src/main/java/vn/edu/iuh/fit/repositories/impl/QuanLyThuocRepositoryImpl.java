/*
 * @ {#} QuanLyThuocRepositoryImpl.java   1.0     24/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import vn.edu.iuh.fit.entities.Loaithuoc;
import vn.edu.iuh.fit.entities.Thuoc;
import vn.edu.iuh.fit.repositories.QuanLyThuocRepository;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   24/10/2024
 * @version:    1.0
 */
public class QuanLyThuocRepositoryImpl implements QuanLyThuocRepository {
    private EntityManager ẹm;

    public QuanLyThuocRepositoryImpl() {
        this.ẹm = Persistence.createEntityManagerFactory("mariadb").createEntityManager();
    }

    @Override
    public List<Thuoc> getAll() {
        String query = "SELECT t FROM Thuoc t";
        return ẹm.createQuery(query, Thuoc.class).getResultList();
    }

    @Override
    public List<Loaithuoc> getAllLoaiThuoc() {
        String query = "SELECT lt FROM Loaithuoc lt";
        return ẹm.createQuery(query, Loaithuoc.class).getResultList();
    }

    @Override
    public List<Thuoc> getListThuocByLoai(int maLoaiThuoc) {
        String query = "SELECT t FROM Thuoc t WHERE t.maloai.id = :maLoaiThuoc";
        return ẹm.createQuery(query, Thuoc.class).setParameter("maLoaiThuoc", maLoaiThuoc).getResultList();
    }

    @Override
    public boolean save(Thuoc thuoc) {
        try {
            EntityTransaction tr = ẹm.getTransaction();
            tr.begin();
            ẹm.persist(thuoc);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Loaithuoc getById(int id) {
        return ẹm.find(Loaithuoc.class, id);
    }
}
