package vn.edu.iuh.fit.entities;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "loaithuoc")
@NamedQueries({
        @NamedQuery(name = "LoaiThuoc.findAll", query = "select lt from LoaiThuoc lt"),
})
public class LoaiThuoc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MALOAI", nullable = false)
    private Integer id;

    @Column(name = "TENLOAI")
    private String tenloai;

    @JsonbTransient
    @OneToMany(mappedBy = "maloai", fetch = FetchType.EAGER)
    private Set<Thuoc> thuocs = new LinkedHashSet<>();

    public LoaiThuoc() {
    }

    public LoaiThuoc(String tenloai) {
        this.tenloai = tenloai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public Set<Thuoc> getThuocs() {
        return thuocs;
    }

    public void setThuocs(Set<Thuoc> thuocs) {
        this.thuocs = thuocs;
    }

    @Override
    public String toString() {
        return "LoaiThuoc{" +
                "id=" + id +
                ", tenloai='" + tenloai + '\'' +
                '}';
    }
}