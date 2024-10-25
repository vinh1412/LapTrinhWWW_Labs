/*
 * @ {#} XeDAO.java   1.0     25/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.entities.Xe;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   25/10/2024
 * @version:    1.0
 */
public interface XeDAO {
    List<Xe> getDsXe();
    Xe findById(int idXe);
    Xe findByName(String tenxe);
    Xe addXe(Xe xe);
    Xe editXe(Xe xe);
    Xe deleteXe(Xe xe);
}
