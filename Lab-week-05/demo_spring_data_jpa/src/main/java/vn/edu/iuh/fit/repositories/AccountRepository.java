package vn.edu.iuh.fit.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Account;

import java.util.List;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
    Page<Account> getAccountByBalanceGreaterThan(double balance, Pageable pageable);
}
