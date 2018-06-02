package cn.gson.crm.model.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Region {
    private int regionCode;
    private int cityCode;
    private String region;
    private int regionPeopleNumber;

    @Id
    @Column(name = "region_code", nullable = false)
    public int getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(int regionCode) {
        this.regionCode = regionCode;
    }

    @Basic
    @Column(name = "city_code", nullable = false)
    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    @Basic
    @Column(name = "region_", nullable = false, length = 255)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "region_people_number", nullable = false)
    public int getRegionPeopleNumber() {
        return regionPeopleNumber;
    }

    public void setRegionPeopleNumber(int regionPeopleNumber) {
        this.regionPeopleNumber = regionPeopleNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region1 = (Region) o;
        return regionCode == region1.regionCode &&
                cityCode == region1.cityCode &&
                regionPeopleNumber == region1.regionPeopleNumber &&
                Objects.equals(region, region1.region);
    }

    @Override
    public int hashCode() {

        return Objects.hash(regionCode, cityCode, region, regionPeopleNumber);
    }
}
