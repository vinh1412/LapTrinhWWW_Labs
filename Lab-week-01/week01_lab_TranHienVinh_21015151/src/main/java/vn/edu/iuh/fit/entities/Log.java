package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "log")
@NamedQueries({
        @NamedQuery(name = "Log.findAll", query = "select l from Log l"),
        @NamedQuery(name = "Log.findById", query = "select l from Log l where l.id = :id"),
        @NamedQuery(name = "Log.updateById", query = "update Log l set l.accountId = :accountId, l.loginTime = :loginTime, l.logoutTime = :logoutTime, l.notes = :notes where l.id = :id"),
        @NamedQuery(name = "Log.existsById", query = "select (count(l) > 0) from Log l where l.id = :id"),
        @NamedQuery(name = "Log.deleteById", query = "delete from Log l where l.id = :id")
})
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "account_id", nullable = false, length = 50)
    private String accountId;

    @ColumnDefault("current_timestamp()")
    @Column(name = "login_time", nullable = false)
    private Instant loginTime;

    @ColumnDefault("current_timestamp()")
    @Column(name = "logout_time")
    private Instant logoutTime;

    @ColumnDefault("''")
    @Column(name = "notes", nullable = false, length = 250)
    private String notes;

    public Log(String accountId, Instant loginTime, String notes) {
        this.accountId = accountId;
        this.loginTime = loginTime;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", loginTime=" + loginTime +
                ", logoutTime=" + logoutTime +
                ", notes='" + notes + '\'' +
                '}';
    }
}