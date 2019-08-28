package com.company.clientservice.model;

import java.math.BigDecimal;
import java.util.Objects;


public class Banking {

    private Integer id;
    private BigDecimal credit;

    public Banking(Integer id, BigDecimal credit) {
        this.id = id;
        this.credit = credit;
    }

    public Banking() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banking banking = (Banking) o;
        return id.equals(banking.id) &&
                credit.equals(banking.credit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, credit);
    }
}
