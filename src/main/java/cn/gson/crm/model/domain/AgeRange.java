package cn.gson.crm.model.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "age_range", schema = "dpms_db", catalog = "")
public class AgeRange {
    private int ageRangeCode;
    private Integer bottom;
    private Integer top;

    @Id
    @Column(name = "age_range_code", nullable = false)
    public int getAgeRangeCode() {
        return ageRangeCode;
    }

    public void setAgeRangeCode(int ageRangeCode) {
        this.ageRangeCode = ageRangeCode;
    }

    @Basic
    @Column(name = "bottom_", nullable = true)
    public Integer getBottom() {
        return bottom;
    }

    public void setBottom(Integer bottom) {
        this.bottom = bottom;
    }

    @Basic
    @Column(name = "top_", nullable = true)
    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgeRange ageRange = (AgeRange) o;
        return ageRangeCode == ageRange.ageRangeCode &&
                Objects.equals(bottom, ageRange.bottom) &&
                Objects.equals(top, ageRange.top);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ageRangeCode, bottom, top);
    }
}
