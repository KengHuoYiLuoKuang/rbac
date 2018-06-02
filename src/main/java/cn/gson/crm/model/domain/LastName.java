package cn.gson.crm.model.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "last_name", schema = "dpms_db", catalog = "")
public class LastName {
    private int lastNameCode;
    private String lastName;

    @Id
    @Column(name = "last_name_code", nullable = false)
    public int getLastNameCode() {
        return lastNameCode;
    }

    public void setLastNameCode(int lastNameCode) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LastName lastName1 = (LastName) o;
        return lastNameCode == lastName1.lastNameCode &&
                Objects.equals(lastName, lastName1.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lastNameCode, lastName);
    }
}
