package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.Account;

import java.util.List;

public interface AccountService {
    List<Account> getPageNative(int page, int size);
    List<Account> getAccountsByBalanceGreaterThan(double balance, int page, int size);
}
