/*
 * @ {#} AccountImpl.java   1.0     27/08/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.session01.ex01.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.session01.ex01.dao.AccountDao;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   27/08/2024
 * @version:    1.0
 */
public class AccountImpl implements AccountDao {
    private EntityManager em;

    public AccountImpl() {
        em= Persistence.createEntityManagerFactory("JPA_MariaDB").createEntityManager();
    }

    @Override
    public boolean checkLogin(String userName, String passWord) {
        String query = "SELECT a FROM Account a WHERE a.userName = :userName AND a.passWord = :password";
        return !em.createQuery(query)
                .setParameter("userName", userName)
                .setParameter("password", passWord)
                .getResultList().isEmpty();
    }
}
