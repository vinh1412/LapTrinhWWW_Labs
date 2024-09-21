package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "role")
@NamedQueries({
        @NamedQuery(name = "Role.findAll", query = "select r from Role r"),
        @NamedQuery(name = "Role.deleteByRoleId", query = "delete from Role r where r.roleId = :roleId"),
        @NamedQuery(name = "Role.findByRoleId", query = "select r from Role r where r.roleId = :roleId"),
        @NamedQuery(name = "Role.getAccountsByRoleId", query = "select ga.account from GrantAccess ga where ga.role.roleId = :roleId"),
        @NamedQuery(name = "Role.isAdministrator", query = "select count(ga) > 0 from Role r inner join GrantAccess ga on r.roleId = ga.role.roleId inner join Account a on ga.account.accountId = a.accountId where a.accountId = :accountId and r.roleName = 'administrator'"),
})
public class Role {
    @Id
    @Column(name = "role_id", nullable = false, length = 50)
    private String roleId;

    @Column(name = "role_name", nullable = false, length = 50)
    private String roleName;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "status", nullable = false)
    private Byte status;

    @OneToMany(mappedBy = "role")
    private Set<GrantAccess> grantAccesses = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "Role{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}