package vn.edu.iuh.fit.entities;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

@Entity
@Table(name = "thuoc")
@NamedQueries({
    @NamedQuery(name = "Thuoc.findAll", query = "select t from Thuoc t"),
    @NamedQuery(name = "Thuoc.findByLoaiThuoc", query = "select t from Thuoc t where t.maloai.id = :idLoaiThuoc")
})
public class Thuoc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MATHUOC", nullable = false)
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
    @JsonbTransient
    private LoaiThuoc maloai;

    public Thuoc() {
    }

    public Thuoc(String tenthuoc, Double gia, Integer namsx) {
        this.tenthuoc = tenthuoc;
        this.gia = gia;
        this.namsx = namsx;
    }

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

    public LoaiThuoc getMaloai() {
        return maloai;
    }

    public void setMaloai(LoaiThuoc maloai) {
        this.maloai = maloai;
    }

    @Override
    public String toString() {
        return "Thuoc{" +
                "id=" + id +
                ", tenthuoc='" + tenthuoc + '\'' +
                ", gia=" + gia +
                ", namsx=" + namsx +
                '}';
    }
}