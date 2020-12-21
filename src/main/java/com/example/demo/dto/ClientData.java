package com.example.demo.dto;

import java.math.BigDecimal;

public class ClientData {
    private BigDecimal averageAge;
    private BigDecimal desviation;

    public BigDecimal getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(BigDecimal averageAge) {
        this.averageAge = averageAge;
    }

    public BigDecimal getDesviation() {
        return desviation;
    }

    public void setDesviation(BigDecimal desviation) {
        this.desviation = desviation;
    }
}
