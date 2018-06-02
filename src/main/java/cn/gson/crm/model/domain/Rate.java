package cn.gson.crm.model.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Rate {
    private int rateCode;
    private Integer year;
    private Double peopleNumber;
    private Double provinceBirthRate;
    private Double provinceDeathRate;
    private Double provinceGrowthRate;
    private Double cityBirthRate;
    private Double cityDeathRate;
    private Double cityGrowthRate;
    private Double regionBirthRate;
    private Double regionDeathRate;
    private Double regionGrowthRate;

    @Id
    @Column(name = "rate_code", nullable = false)
    public int getRateCode() {
        return rateCode;
    }

    public void setRateCode(int rateCode) {
        this.rateCode = rateCode;
    }

    @Basic
    @Column(name = "year_", nullable = true)
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "people_number", nullable = true, precision = 2)
    public Double getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Double peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    @Basic
    @Column(name = "province_birth_rate", nullable = true, precision = 2)
    public Double getProvinceBirthRate() {
        return provinceBirthRate;
    }

    public void setProvinceBirthRate(Double provinceBirthRate) {
        this.provinceBirthRate = provinceBirthRate;
    }

    @Basic
    @Column(name = "province_death_rate", nullable = true, precision = 2)
    public Double getProvinceDeathRate() {
        return provinceDeathRate;
    }

    public void setProvinceDeathRate(Double provinceDeathRate) {
        this.provinceDeathRate = provinceDeathRate;
    }

    @Basic
    @Column(name = "province_growth_rate", nullable = true, precision = 2)
    public Double getProvinceGrowthRate() {
        return provinceGrowthRate;
    }

    public void setProvinceGrowthRate(Double provinceGrowthRate) {
        this.provinceGrowthRate = provinceGrowthRate;
    }

    @Basic
    @Column(name = "city_birth_rate", nullable = true, precision = 2)
    public Double getCityBirthRate() {
        return cityBirthRate;
    }

    public void setCityBirthRate(Double cityBirthRate) {
        this.cityBirthRate = cityBirthRate;
    }

    @Basic
    @Column(name = "city_death_rate", nullable = true, precision = 2)
    public Double getCityDeathRate() {
        return cityDeathRate;
    }

    public void setCityDeathRate(Double cityDeathRate) {
        this.cityDeathRate = cityDeathRate;
    }

    @Basic
    @Column(name = "city_growth_rate", nullable = true, precision = 2)
    public Double getCityGrowthRate() {
        return cityGrowthRate;
    }

    public void setCityGrowthRate(Double cityGrowthRate) {
        this.cityGrowthRate = cityGrowthRate;
    }

    @Basic
    @Column(name = "region_birth_rate", nullable = true, precision = 2)
    public Double getRegionBirthRate() {
        return regionBirthRate;
    }

    public void setRegionBirthRate(Double regionBirthRate) {
        this.regionBirthRate = regionBirthRate;
    }

    @Basic
    @Column(name = "region_death_rate", nullable = true, precision = 2)
    public Double getRegionDeathRate() {
        return regionDeathRate;
    }

    public void setRegionDeathRate(Double regionDeathRate) {
        this.regionDeathRate = regionDeathRate;
    }

    @Basic
    @Column(name = "region_growth_rate", nullable = true, precision = 2)
    public Double getRegionGrowthRate() {
        return regionGrowthRate;
    }

    public void setRegionGrowthRate(Double regionGrowthRate) {
        this.regionGrowthRate = regionGrowthRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate = (Rate) o;
        return rateCode == rate.rateCode &&
                Objects.equals(year, rate.year) &&
                Objects.equals(peopleNumber, rate.peopleNumber) &&
                Objects.equals(provinceBirthRate, rate.provinceBirthRate) &&
                Objects.equals(provinceDeathRate, rate.provinceDeathRate) &&
                Objects.equals(provinceGrowthRate, rate.provinceGrowthRate) &&
                Objects.equals(cityBirthRate, rate.cityBirthRate) &&
                Objects.equals(cityDeathRate, rate.cityDeathRate) &&
                Objects.equals(cityGrowthRate, rate.cityGrowthRate) &&
                Objects.equals(regionBirthRate, rate.regionBirthRate) &&
                Objects.equals(regionDeathRate, rate.regionDeathRate) &&
                Objects.equals(regionGrowthRate, rate.regionGrowthRate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(rateCode, year, peopleNumber, provinceBirthRate, provinceDeathRate, provinceGrowthRate, cityBirthRate, cityDeathRate, cityGrowthRate, regionBirthRate, regionDeathRate, regionGrowthRate);
    }
}
