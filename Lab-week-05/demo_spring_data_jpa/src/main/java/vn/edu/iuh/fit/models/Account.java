package vn.edu.iuh.fit.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Random;
import java.util.UUID;

@Entity @NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;
    @Column(unique = true, nullable = false)
    @JsonProperty("numberAccount")
    private String numberAccount;
    @JsonProperty("ownerName")
    private String ownerName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("balance")
    private double balance;

    public Account(String ownerName, String email, String password) {
        Random random = new Random();
        this.numberAccount= UUID.randomUUID().toString();
        this.ownerName = ownerName;
        this.email = email;
        this.password = password;
        this.balance = random.nextDouble() * 1000;
    }
}
