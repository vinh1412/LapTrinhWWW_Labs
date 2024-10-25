/*
 * @ {#} QuanLyLoaiThuocImpl.java   1.0     23/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.services.impl;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import vn.edu.iuh.fit.entities.LoaiThuoc;
import vn.edu.iuh.fit.entities.Thuoc;
import vn.edu.iuh.fit.repositories.QuanLyLoaiThuocRepository;
import vn.edu.iuh.fit.services.QuanLyLoaiThuocService;
import vn.edu.iuh.fit.services.QuanLyThuocService;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   23/10/2024
 * @version:    1.0
 */
@Stateless
public class QuanLyLoaiThuocImpl implements QuanLyLoaiThuocService {
    @Inject
    private QuanLyLoaiThuocRepository quanLyLoaiThuocRepository;


    @Override
    public List<LoaiThuoc> getDsLoaiThuoc() {
        return quanLyLoaiThuocRepository.getDsLoaiThuoc();
    }

    @Override
    public List<Thuoc> getDsThuocByLoaiThuoc(int idLoaiThuoc) {
        return quanLyLoaiThuocRepository.getDsThuocByLoaiThuoc(idLoaiThuoc);
    }
}
