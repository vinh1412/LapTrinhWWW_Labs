/*
 * @ {#} QuanLyLoaiThuocService.java   1.0     23/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.services;

import jakarta.ejb.Remote;
import vn.edu.iuh.fit.entities.LoaiThuoc;
import vn.edu.iuh.fit.entities.Thuoc;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   23/10/2024
 * @version:    1.0
 */
@Remote
public interface QuanLyLoaiThuocService {
    List<LoaiThuoc> getDsLoaiThuoc();
    List<Thuoc> getDsThuocByLoaiThuoc(int idLoaiThuoc);
}
