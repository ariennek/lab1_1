package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 * Created by 195035 on 3/7/2017.
 */
public class Money implements Comparable<Money> {

    public final String currency;
    public final BigDecimal value;

    public Money(String currency, BigDecimal value) {
        this.currency = currency;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (currency != null ? !currency.equals(money.currency) : money.currency != null) return false;
        return value != null ? value.equals(money.value) : money.value == null;
    }

    @Override
    public int hashCode() {
        int result = currency != null ? currency.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }


    public int compareTo(Money other) {
        if(currency != null && other.currency != null && !currency.equalsIgnoreCase(other.currency)) {
            throw new IllegalArgumentException("Currency mismatch");
        }

        if(value != null && other.value != null) {
            return value.compareTo(other.value);
        }

        return 0;
    }
}
