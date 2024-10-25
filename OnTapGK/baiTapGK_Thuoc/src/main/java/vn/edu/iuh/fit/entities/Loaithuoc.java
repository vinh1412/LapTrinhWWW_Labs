package vn.edu.iuh.fit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "loaithuoc")
public class Loaithuoc implements Serializable {
    @Id
    @Column(name = "MALOAI", nullable = false)
    private Integer id;

    @Column(name = "TENLOAI")
    private String tenloai;

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

}