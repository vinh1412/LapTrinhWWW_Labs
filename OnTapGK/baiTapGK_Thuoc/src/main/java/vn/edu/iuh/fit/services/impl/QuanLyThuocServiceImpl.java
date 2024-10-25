/*
 * @ {#} QuanLyThuocService.java   1.0     24/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.services.impl;

import vn.edu.iuh.fit.entities.Loaithuoc;
import vn.edu.iuh.fit.entities.Thuoc;
import vn.edu.iuh.fit.repositories.QuanLyThuocRepository;
import vn.edu.iuh.fit.repositories.impl.QuanLyThuocRepositoryImpl;
import vn.edu.iuh.fit.services.QuanLyThuocService;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   24/10/2024
 * @version:    1.0
 */
public class QuanLyThuocServiceImpl implements QuanLyThuocService {
    private QuanLyThuocRepository quanLyThuocRepository;

    public QuanLyThuocServiceImpl() {
        this.quanLyThuocRepository = new QuanLyThuocRepositoryImpl();
    }

    @Override
    public List<Thuoc> getAll() {
        return quanLyThuocRepository.getAll();
    }

    @Override
    public List<Loaithuoc> getAllLoaiThuoc() {
        return quanLyThuocRepository.getAllLoaiThuoc();
    }

    @Override
    public List<Thuoc> getListThuocByLoai(int maLoaiThuoc) {
        return quanLyThuocRepository.getListThuocByLoai(maLoaiThuoc);
    }

    @Override
    public boolean save(Thuoc thuoc) {
        return quanLyThuocRepository.save(thuoc);
    }

    @Override
    public Loaithuoc getById(int id) {
        return quanLyThuocRepository.getById(id);
    }
}
