package cn.gson.crm.model.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class City {
    private int cityCode;
    private String city;
    private int provinceCode;

    @Id
    @Column(name = "city_code", nullable = false)
    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    @Basic
    @Column(name = "city_", nullable = false, length = 255)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "province_code", nullable = false)
    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return cityCode == city1.cityCode &&
                provinceCode == city1.provinceCode &&
                Objects.equals(city, city1.city);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cityCode, city, provinceCode);
    }
}
