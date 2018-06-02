package cn.gson.crm.model.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Nation {
    private int nationCode;
    private String nation;

    @Id
    @Column(name = "nation_code", nullable = false)
    public int getNationCode() {
        return nationCode;
    }

    public void setNationCode(int nationCode) {
        this.nationCode = nationCode;
    }

    @Basic
    @Column(name = "nation_", nullable = false, length = 255)
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nation nation1 = (Nation) o;
        return nationCode == nation1.nationCode &&
                Objects.equals(nation, nation1.nation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nationCode, nation);
    }
}
