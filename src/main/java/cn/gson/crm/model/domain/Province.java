package cn.gson.crm.model.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Province {
    private Long provinceCode;
    private String province;

    @Id
    @Column(name = "province_code", nullable = false)
    public Long getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(Long provinceCode) {
        this.provinceCode = provinceCode;
    }

    @Basic
    @Column(name = "province_", nullable = false, length = 255)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Province province1 = (Province) o;
        return provinceCode == province1.provinceCode &&
                Objects.equals(province, province1.province);
    }

    @Override
    public int hashCode() {

        return Objects.hash(provinceCode, province);
    }
}
