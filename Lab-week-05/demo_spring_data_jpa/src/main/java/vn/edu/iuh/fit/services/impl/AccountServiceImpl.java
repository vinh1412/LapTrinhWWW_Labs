package vn.edu.iuh.fit.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.services.AccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public List<Account> getPageNative(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Account> accounts = accountRepository.findAll(pageRequest);
        return accounts.getContent();
    }

    @Override
    public List<Account> getAccountsByBalanceGreaterThan(double balance, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size).withSort(Sort.by("balance").descending());
        Page<Account> accounts = accountRepository.getAccountByBalanceGreaterThan(balance, pageRequest);
        return accounts.getContent();
    }
}
