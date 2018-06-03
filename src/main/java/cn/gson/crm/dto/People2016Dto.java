package cn.gson.crm.dto;

public class People2016Dto {
    String realName;
    Byte gender;
    String idCardNumber;
    String birthDate;
    int age;
    String telephone;
    int nation;
    int province;
    int city;
    int region;
    int profession;
    boolean urban;
    boolean floating;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getNation() {
        return nation;
    }

    public void setNation(int nation) {
        this.nation = nation;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public int getProfession() {
        return profession;
    }

    public void setProfession(int profession) {
        this.profession = profession;
    }

    public boolean isUrban() {
        return urban;
    }

    public void setUrban(boolean urban) {
        this.urban = urban;
    }

    public boolean isFloating() {
        return floating;
    }

    public void setFloating(boolean floating) {
        this.floating = floating;
    }

    @Override
    public String toString() {
        return "People2016Dto{" +
                "realName='" + realName + '\'' +
                ", gender=" + gender +
                ", idCardNumber='" + idCardNumber + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", nation=" + nation +
                ", province=" + province +
                ", city=" + city +
                ", region=" + region +
                ", profession='" + profession + '\'' +
                ", urban=" + urban +
                ", floating=" + floating +
                '}';
    }
}
