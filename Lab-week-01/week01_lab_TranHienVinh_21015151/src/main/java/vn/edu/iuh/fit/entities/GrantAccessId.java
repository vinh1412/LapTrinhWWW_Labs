package vn.edu.iuh.fit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class GrantAccessId implements Serializable {
    private static final long serialVersionUID = -7905915336764383276L;
    @Column(name = "role_id", nullable = false, length = 50)
    private String roleId;

    @Column(name = "account_id", nullable = false, length = 50)
    private String accountId;

    public GrantAccessId(String roleId, String accountId) {
        this.roleId = roleId;
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GrantAccessId entity = (GrantAccessId) o;
        return Objects.equals(this.accountId, entity.accountId) &&
                Objects.equals(this.roleId, entity.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, roleId);
    }

    @Override
    public String toString() {
        return "GrantAccessId{" +
                "roleId='" + roleId + '\'' +
                ", accountId='" + accountId + '\'' +
                '}';
    }
}