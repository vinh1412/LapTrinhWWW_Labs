/*
 * @ {#} GrantAccessRepository.java   1.0     09/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.GrantAccess;
import vn.edu.iuh.fit.entities.GrantAccessId;
import vn.edu.iuh.fit.entities.Role;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   09/09/2024
 * @version:    1.0
 */
public class GrantAccessRepository {
    private EntityManager em;
    private AccountRepository accountRepository;
    private RoleRepository roleRepository;

    public GrantAccessRepository() {
        em = Persistence.createEntityManagerFactory("mariadb").createEntityManager();
        accountRepository = new AccountRepository();
        roleRepository = new RoleRepository();
    }
    public List<GrantAccess> findAccountByRoleId(String roleId) {
        return em.createNamedQuery("GrantAccess.findAccountByRoleId", GrantAccess.class).setParameter("roleId", roleId).getResultList();
    }

    public List<GrantAccess> findRoleByAccountId(String accountId) {
        return em.createNamedQuery("GrantAccess.findRoleByAccountId", GrantAccess.class).setParameter("accountId", accountId).getResultList();
    }

    public boolean update(GrantAccess grantAccess) {
        em.getTransaction().begin();
        em.merge(grantAccess);
        em.getTransaction().commit();
        return true;
    }

    public boolean delete(GrantAccess grantAccess) {
        em.getTransaction().begin();
        em.remove(grantAccess);
        em.getTransaction().commit();
        return true;
    }

    public boolean exists(String accountId, String roleId) {
        return em.createNamedQuery("GrantAccess.exists", Boolean.class).setParameter("accountId", accountId).setParameter("roleId", roleId).getSingleResult();
    }
}
