/*
 * @ {#} RoleRepository.java   1.0     08/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.reponsitories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.Role;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   08/09/2024
 * @version:    1.0
 */
public class RoleRepository {
    private EntityManager em;

    public RoleRepository() {
        em= Persistence.createEntityManagerFactory("mariadb").createEntityManager();
    }

    //Find all roles
    public List<Role> findAll() {
        return em.createNamedQuery("Role.findAll", Role.class).getResultList();
    }
    //Add new role
    public boolean addRole(Role role) {
        try {
            em.getTransaction().begin();
            em.persist(role);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return false;
    }

    //Update role
    public boolean updateRole(Role role) {
        try {
            em.getTransaction().begin();
            em.merge(role);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return false;
    }

    //Delete role
    public boolean deleteRole(Role role) {
        return em.createNamedQuery("Role.deleteByRoleId").setParameter("roleId", role.getRoleId()).executeUpdate() > 0;
    }
    public boolean isAdministrator(String accountId) {
        return em.createNamedQuery("Role.isAdministrator", Boolean.class).setParameter("accountId", accountId).getSingleResult();
    }
    //Tìm role theo roleId
    public Role findByRoleId(String roleId){
        try {
            List<Role> results = em.createNamedQuery("Role.findByRoleId", Role.class).setParameter("roleId", roleId).getResultList();
            return results.stream().findFirst().orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
