package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "account")
@NamedQueries({
        @NamedQuery(name = "Account.findAll", query = "select a from Account a"),
        @NamedQuery(name = "Account.deleteByAccountId", query = "delete from Account a where a.accountId = :accountId"),
        @NamedQuery(name = "Account.checkLogin", query = "select a from Account a where a.accountId = :accountId and a.password = :password"),
        @NamedQuery(name="Account.findByAccountId", query = "select a from Account a where a.accountId = :accountId"),
        @NamedQuery(name = "Account.existsByAccountId", query = "select (count(a) > 0) from Account a where a.accountId = :accountId"),
        @NamedQuery(name = "Account.findByRoleId", query = "select a from Account a inner join GrantAccess ga on a.accountId = ga.account.accountId inner join Role r on ga.role.roleId = r.roleId where r.roleId = :roleId"),
        @NamedQuery(name = "Account.findByRoleName", query = "select a from Account a inner join GrantAccess ga on a.accountId = ga.account.accountId inner join Role r on ga.role.roleId = r.roleId where r.roleName = :roleName"),
})
public class Account {
    @Id
    @Column(name = "account_id", nullable = false, length = 50)
    private String accountId;

    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "phone", length = 50)
    private String phone;

    @ColumnDefault("1")
    @Column(name = "status", nullable = false)
    private Byte status;

    @OneToMany(mappedBy = "account")
    private Set<GrantAccess> grantAccesses = new LinkedHashSet<>();

    public Account(String accountId, String fullName, String password, String email, String phone, Byte status) {
        this.accountId = accountId;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}