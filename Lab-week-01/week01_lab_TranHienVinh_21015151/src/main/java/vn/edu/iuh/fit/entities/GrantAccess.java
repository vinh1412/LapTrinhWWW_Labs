package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "grant_access")
@NamedQueries({
        @NamedQuery(name = "GrantAccess.findAccountByRoleId",query = "select g from GrantAccess g where g.id.roleId = :roleId order by g.id.roleId"),
        @NamedQuery(name = "GrantAccess.findRoleByAccountId", query = "select g from GrantAccess g where g.id.accountId = :accountId order by g.id.accountId"),
        @NamedQuery(name = "GrantAccess.deleteById_AccountId", query = "delete from GrantAccess g where g.id.accountId = :accountId"),
        @NamedQuery(name = "GrantAccess.exists", query = "select (count(g) > 0) from GrantAccess g where g.id.roleId = :roleId and g.id.accountId = :accountId")
})
public class GrantAccess {
    @EmbeddedId
    private GrantAccessId id;

    @MapsId("roleId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @MapsId("accountId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ColumnDefault("b'1'")
    @Column(name = "is_grant", nullable = false)
    private Boolean isGrant = false;

    @ColumnDefault("''")
    @Column(name = "note", length = 250)
    private String note;

    @Override
    public String toString() {
        return "GrantAccess{" +
                "id=" + id +
                ", role=" + role +
                ", account=" + account +
                ", isGrant=" + isGrant +
                ", note='" + note + '\'' +
                '}';
    }
}