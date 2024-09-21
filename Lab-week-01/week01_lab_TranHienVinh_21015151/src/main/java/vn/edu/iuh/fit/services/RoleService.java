/*
 * @ {#} RoleService.java   1.0     19/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.GrantAccess;
import vn.edu.iuh.fit.entities.GrantAccessId;
import vn.edu.iuh.fit.entities.Role;
import vn.edu.iuh.fit.reponsitories.AccountRepository;
import vn.edu.iuh.fit.reponsitories.GrantAccessRepository;
import vn.edu.iuh.fit.reponsitories.RoleRepository;

import java.util.ArrayList;
import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   19/09/2024
 * @version:    1.0
 */
public class RoleService {
    private RoleRepository roleRepository;
    private GrantAccessRepository grantAccessRepository;
    private AccountRepository accountRepository;

    public RoleService() {
        this.roleRepository = new RoleRepository();
        this.grantAccessRepository = new GrantAccessRepository();
        this.accountRepository = new AccountRepository();
    }
    public boolean isAdministrator(String accountId) {
        return roleRepository.isAdministrator(accountId);
    }
    public List<String> findRoleByAccountId(String accountId) {
        List<GrantAccess> roles = grantAccessRepository.findRoleByAccountId(accountId);
        List<String> roleNames = new ArrayList<>();
        for (GrantAccess grantAccess : roles) {
            roleNames.add(grantAccess.getRole().getRoleName());
        }
        return roleNames;
    }

    public boolean grantRole(String accountId, String roleId) {
        if (grantAccessRepository.exists(accountId, roleId)) {
            return false;
        }

        Role role = roleRepository.findByRoleId(roleId);
        GrantAccess grantAccess = new GrantAccess();
        GrantAccessId grantAccessId = new GrantAccessId(role.getRoleId(), accountId);

        grantAccess.setId(grantAccessId);
        grantAccess.setRole(role);
        grantAccess.setAccount(accountRepository.findAccountByID(accountId));

        return grantAccessRepository.update(grantAccess);
    }

    public List<String> findAll() {
        List<Role> roles = roleRepository.findAll();
        List<String> roleNames = new ArrayList<>();
        for (Role role : roles) {
            roleNames.add(role.getRoleName());
        }
        return roleNames;
    }

}
