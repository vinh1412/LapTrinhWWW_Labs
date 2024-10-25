package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

@Entity
@Table(name = "thuoc")
public class Thuoc implements Serializable {
    @Id
    @Column(name = "MATHUOC", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TENTHUOC")
    private String tenthuoc;

    @Column(name = "GIA")
    private Double gia;

    @Column(name = "NAMSX")
    private Integer namsx;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "MALOAI")
    private Loaithuoc maloai;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenthuoc() {
        return tenthuoc;
    }

    public void setTenthuoc(String tenthuoc) {
        this.tenthuoc = tenthuoc;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public Integer getNamsx() {
        return namsx;
    }

    public void setNamsx(Integer namsx) {
        this.namsx = namsx;
    }

    public Loaithuoc getMaloai() {
        return maloai;
    }

    public void setMaloai(Loaithuoc maloai) {
        this.maloai = maloai;
    }

}