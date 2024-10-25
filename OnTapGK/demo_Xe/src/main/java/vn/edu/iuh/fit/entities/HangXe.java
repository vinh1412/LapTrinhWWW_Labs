package vn.edu.iuh.fit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "hangxe")
public class HangXe {
    @Id
    @Column(name = "mahangxe", nullable = false)
    private Integer id;

    @ColumnDefault("'0'")
    @Column(name = "tenhang", nullable = false, length = 50)
    private String tenhang;

    @ColumnDefault("'0'")
    @Column(name = "quocgia", nullable = false, length = 50)
    private String quocgia;

    @ColumnDefault("'0'")
    @Column(name = "mota", nullable = false, length = 50)
    private String mota;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    public String getQuocgia() {
        return quocgia;
    }

    public void setQuocgia(String quocgia) {
        this.quocgia = quocgia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

}