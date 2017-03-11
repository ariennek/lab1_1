package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 * User: Klaudia
 * Date: 11.03.2017
 * Time: 23:44
 */
public class Money {
    private BigDecimal totalCost;
    private String currency;

    public Money(BigDecimal totalCost, String currency) {
        this.totalCost = totalCost;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return totalCost != null ? totalCost.equals(money.totalCost) : money.totalCost == null;
    }

    @Override
    public int hashCode() {
        return totalCost != null ? totalCost.hashCode() : 0;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
