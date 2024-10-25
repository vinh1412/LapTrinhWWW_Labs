/*
 * @ {#} QuanLyThuocService.java   1.0     24/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Loaithuoc;
import vn.edu.iuh.fit.entities.Thuoc;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   24/10/2024
 * @version:    1.0
 */
public interface QuanLyThuocService {
    List<Thuoc> getAll();
    public List<Loaithuoc> getAllLoaiThuoc();
    public List<Thuoc> getListThuocByLoai(int maLoaiThuoc);
    public boolean save(Thuoc thuoc);
    public Loaithuoc getById(int id);
}
