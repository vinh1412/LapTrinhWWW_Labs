/*
 * @ {#} AccountRepository.java   1.0     08/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.GrantAccess;
import vn.edu.iuh.fit.entities.Role;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   08/09/2024
 * @version:    1.0
 */
public class AccountRepository {
    private EntityManager em;

    public AccountRepository() {
        em= Persistence.createEntityManagerFactory("mariadb").createEntityManager();
    }
    public List<Account> findAll() {
        return em.createNamedQuery("Account.findAll", Account.class).getResultList();
    }

    //Add new account
    public boolean addAccount(Account account) {
        try {
            em.getTransaction().begin();
            em.persist(account);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return false;
    }

    //Update account
    public boolean updateAccount(Account account) {
        Account a = em.find(Account.class, account.getAccountId());
        if (a == null) {
            return false;
        }
        try {
            em.getTransaction().begin();
            em.merge(account);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return false;
    }

    //Delete account
    public boolean deleteAccount(Account account) {
        Account a = em.find(Account.class, account.getAccountId());
        if (a == null) {
            return false;
        }
        try {
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return false;
    }

    //Check login
    public boolean checkLogin(String accountId, String password) {
        return em.createNamedQuery("Account.checkLogin", Account.class).setParameter("accountId", accountId).setParameter("password", password).getSingleResult() != null;
    }

    // Hiển thị thông tin tài khoản (nếu đăng nhập thành công)
    public Account findAccountByID(String accountId) {
            List<Account> results = em.createNamedQuery("Account.findByAccountId", Account.class).setParameter("accountId", accountId).getResultList();
            return results.stream().findFirst().orElse(null);
    }
    public boolean exists(String id) {
        return em.createNamedQuery("Account.existsByAccountId", Boolean.class).setParameter("accountId", id).getSingleResult();
    }

    public List<Account> findAccountByRoleId(String roleId) {
        return em.createNamedQuery("Account.findByRoleId", Account.class).setParameter("roleId", roleId).getResultList();
    }
    public List<Account> findAccountByRoleName(String roleName) {
        List<Account> accounts = em.createNamedQuery("Account.findByRoleName", Account.class).setParameter("roleName", roleName).getResultList();
        return accounts;
    }
}
