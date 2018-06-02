package cn.gson.crm.model.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Profession {
    private int professionCode;
    private String profession;

    @Id
    @Column(name = "profession_code", nullable = false)
    public int getProfessionCode() {
        return professionCode;
    }

    public void setProfessionCode(int professionCode) {
        this.professionCode = professionCode;
    }

    @Basic
    @Column(name = "profession_", nullable = false, length = 255)
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profession that = (Profession) o;
        return professionCode == that.professionCode &&
                Objects.equals(profession, that.profession);
    }

    @Override
    public int hashCode() {

        return Objects.hash(professionCode, profession);
    }
}
