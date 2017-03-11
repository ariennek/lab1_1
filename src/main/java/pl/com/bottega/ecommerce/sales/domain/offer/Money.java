package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 * User: Klaudia
 * Date: 11.03.2017
 * Time: 23:44
 */
public class Money {
    private BigDecimal totalCost;
    private Currency currency;

    public Money(BigDecimal totalCost, Currency currency) {
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
