package cn.gson.crm.model.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class People2016 {
    private String idNumber;
    private int id;
    private Integer lastNameCode;
    private String lastName;
    private String firstName;
    private Byte gender;
    private Integer ageRangeCode;
    private Integer age;
    private Integer nationCode;
    private String nation;
    private Integer provinceCode;
    private String province;
    private Integer cityCode;
    private String city;
    private Integer regionCode;
    private String region;
    private Integer professionCode;
    private String profession;
    private byte floating;
    private byte urban;
    private String idCardNumber;

    @Basic
    @Column(name = "id_number", nullable = true, length = 255)
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Id
    @Column(name = "id_", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "last_name_code", nullable = true)
    public Integer getLastNameCode() {
        return lastNameCode;
    }

    public void setLastNameCode(Integer lastNameCode) {
        this.lastNameCode = lastNameCode;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 255)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "gender_", nullable = true)
    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "age_range_code", nullable = true)
    public Integer getAgeRangeCode() {
        return ageRangeCode;
    }

    public void setAgeRangeCode(Integer ageRangeCode) {
        this.ageRangeCode = ageRangeCode;
    }

    @Basic
    @Column(name = "age_", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "nation_code", nullable = true)
    public Integer getNationCode() {
        return nationCode;
    }

    public void setNationCode(Integer nationCode) {
        this.nationCode = nationCode;
    }

    @Basic
    @Column(name = "nation_", nullable = true, length = 255)
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Basic
    @Column(name = "province_code", nullable = true)
    public Integer getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    @Basic
    @Column(name = "province_", nullable = true, length = 255)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city_code", nullable = true)
    public Integer getCityCode() {
        return cityCode;
    }

    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    @Basic
    @Column(name = "city_", nullable = true, length = 255)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "region_code", nullable = true)
    public Integer getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Integer regionCode) {
        this.regionCode = regionCode;
    }

    @Basic
    @Column(name = "region_", nullable = true, length = 255)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "profession_code", nullable = true)
    public Integer getProfessionCode() {
        return professionCode;
    }

    public void setProfessionCode(Integer professionCode) {
        this.professionCode = professionCode;
    }

    @Basic
    @Column(name = "profession_", nullable = true, length = 255)
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Basic
    @Column(name = "floating", nullable = false)
    public byte getFloating() {
        return floating;
    }

    public void setFloating(byte floating) {
        this.floating = floating;
    }

    @Basic
    @Column(name = "urban", nullable = false)
    public byte getUrban() {
        return urban;
    }

    public void setUrban(byte urban) {
        this.urban = urban;
    }

    @Basic
    @Column(name = "idCardNumber", nullable = false, length = 20)
    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People2016 that = (People2016) o;
        return id == that.id &&
                floating == that.floating &&
                urban == that.urban &&
                Objects.equals(idNumber, that.idNumber) &&
                Objects.equals(lastNameCode, that.lastNameCode) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(ageRangeCode, that.ageRangeCode) &&
                Objects.equals(age, that.age) &&
                Objects.equals(nationCode, that.nationCode) &&
                Objects.equals(nation, that.nation) &&
                Objects.equals(provinceCode, that.provinceCode) &&
                Objects.equals(province, that.province) &&
                Objects.equals(cityCode, that.cityCode) &&
                Objects.equals(city, that.city) &&
                Objects.equals(regionCode, that.regionCode) &&
                Objects.equals(region, that.region) &&
                Objects.equals(professionCode, that.professionCode) &&
                Objects.equals(profession, that.profession) &&
                Objects.equals(idCardNumber, that.idCardNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idNumber, id, lastNameCode, lastName, firstName, gender, ageRangeCode, age, nationCode, nation, provinceCode, province, cityCode, city, regionCode, region, professionCode, profession, floating, urban, idCardNumber);
    }
}
