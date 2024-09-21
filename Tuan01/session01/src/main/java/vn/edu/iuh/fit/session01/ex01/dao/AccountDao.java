/*
 * @ {#} AccountDao.java   1.0     27/08/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.session01.ex01.dao;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   27/08/2024
 * @version:    1.0
 */
public interface AccountDao {
    public boolean checkLogin(String userName, String passWord);
}
