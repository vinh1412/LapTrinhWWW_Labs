package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "xe")
public class Xe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maxe", nullable = false)
    private Integer id;

    @ColumnDefault("'0'")
    @Column(name = "tenxe", nullable = false, length = 50)
    private String tenxe;

    @ColumnDefault("0")
    @Column(name = "giaxe", nullable = false)
    private Double giaxe;

    @ColumnDefault("0")
    @Column(name = "namsanxuat", nullable = false)
    private Integer namsanxuat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("0")
    @JoinColumn(name = "mahangxe", nullable = false)
    private HangXe mahangxe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public Double getGiaxe() {
        return giaxe;
    }

    public void setGiaxe(Double giaxe) {
        this.giaxe = giaxe;
    }

    public Integer getNamsanxuat() {
        return namsanxuat;
    }

    public void setNamsanxuat(Integer namsanxuat) {
        this.namsanxuat = namsanxuat;
    }

    public HangXe getMahangxe() {
        return mahangxe;
    }

    public void setMahangxe(HangXe mahangxe) {
        this.mahangxe = mahangxe;
    }

}