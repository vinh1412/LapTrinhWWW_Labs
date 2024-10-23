package vn.edu.iuh.fit.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.services.AccountService;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountResource {
    private AccountService accountService;

    @Autowired
    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{page}/{size}")
    public List<Account> getAccounts(@PathVariable int page, @PathVariable int size) {
        return accountService.getPageNative(page, size);
    }

    @GetMapping("/balance")
    public ResponseEntity<List<Account>> getAccountsByBalanceGreaterThan(@RequestParam(value = "balance") double balance, @RequestParam(value = "page") int page, @RequestParam(value = "size") int size) {
        return ResponseEntity.ok(accountService.getAccountsByBalanceGreaterThan(balance, page, size));
    }
}
