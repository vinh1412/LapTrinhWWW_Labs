/*
 * @ {#} QuanLyThuocRepository.java   1.0     24/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.entities.Loaithuoc;
import vn.edu.iuh.fit.entities.Thuoc;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   24/10/2024
 * @version:    1.0
 */
public interface QuanLyThuocRepository {
    List<Thuoc> getAll();
    List<Loaithuoc> getAllLoaiThuoc();
    List<Thuoc> getListThuocByLoai(int maLoaiThuoc);
    boolean save(Thuoc thuoc);
    Loaithuoc getById(int id);
}
