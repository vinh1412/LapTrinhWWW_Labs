package vn.edu.iuh.fit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;

@SpringBootApplication
public class DemoSpringDataJpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringDataJpaApplication.class, args);
    }

//    @Autowired
//    private AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {
//        for (int i = 0; i < 100; i++) {
//            accountRepository.save(new Account("Owner " + i, "owner" + i + "@gmail.com", "123456"));
//        }
//        PageRequest pageRequest = PageRequest.of(0, 10);
//        accountRepository.getAccountByBalanceGreaterThan(500, pageRequest).forEach(System.out::println);
    }
}
