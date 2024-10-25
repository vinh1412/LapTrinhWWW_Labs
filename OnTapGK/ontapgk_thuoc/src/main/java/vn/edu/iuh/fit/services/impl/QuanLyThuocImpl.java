/*
 * @ {#} QuanLyThuocImpl.java   1.0     23/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.services.impl;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import vn.edu.iuh.fit.entities.Thuoc;
import vn.edu.iuh.fit.repositories.QuanLyThuocRepository;
import vn.edu.iuh.fit.services.QuanLyThuocService;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   23/10/2024
 * @version:    1.0
 */
@Stateless
public class QuanLyThuocImpl implements QuanLyThuocService {
    @Inject
    private QuanLyThuocRepository quanLyThuocRepository;
    @Override
    public List<Thuoc> getDsThuoc() {
        List<Thuoc> thuocs = quanLyThuocRepository.getDsThuoc();
        return thuocs;
    }
    @Override
    public Thuoc add(Thuoc thuoc) {
        return quanLyThuocRepository.add(thuoc);
    }
}
