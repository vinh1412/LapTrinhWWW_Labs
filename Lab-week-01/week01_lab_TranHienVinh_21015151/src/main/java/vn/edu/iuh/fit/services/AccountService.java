/*
 * @ {#} AccountService.java   1.0     14/09/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.GrantAccess;
import vn.edu.iuh.fit.entities.GrantAccessId;
import vn.edu.iuh.fit.entities.Role;
import vn.edu.iuh.fit.reponsitories.AccountRepository;
import vn.edu.iuh.fit.reponsitories.GrantAccessRepository;
import vn.edu.iuh.fit.reponsitories.RoleRepository;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   14/09/2024
 * @version:    1.0
 */
public class AccountService {
    private AccountRepository accountRepository;
    private GrantAccessRepository grantAccessRepository;
    private RoleRepository roleRepository;

    public AccountService() {
        this.accountRepository = new AccountRepository();
        this.grantAccessRepository = new GrantAccessRepository();
        this.roleRepository = new RoleRepository();
    }
    public boolean addAccount(Account account) {
        if (exists(account)) {
            return false;
        } else {
            accountRepository.addAccount(account);
            Role userRole = roleRepository.findByRoleId("user");
            GrantAccess grantAccess = new GrantAccess();
            GrantAccessId grantAccessId = new GrantAccessId();
            grantAccessId.setAccountId(account.getAccountId());
            grantAccessId.setRoleId(userRole.getRoleId());
            grantAccess.setId(grantAccessId);
            grantAccess.setAccount(account);
            grantAccess.setRole(userRole);
            return grantAccessRepository.update(grantAccess);
        }
    }
    private boolean exists(Account account) {
        return accountRepository.exists(account.getAccountId());
    }
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findAccountById(String id) {
        return accountRepository.findAccountByID(id);
    }

    public boolean updateAccount(Account account) {
        return accountRepository.updateAccount(account);
    }

    public boolean deleteAccount(Account account) {
        return accountRepository.deleteAccount(account);
    }

    public boolean checkLogin(String accountId, String password) {
        return accountRepository.checkLogin(accountId, password);
    }

    public List<Account> findAccountByRoleId(String roleId) {
        return accountRepository.findAccountByRoleId(roleId);
    }

    public List<Account> findAccountByRoleName(String roleName) {
        return accountRepository.findAccountByRoleName(roleName);
    }
}
