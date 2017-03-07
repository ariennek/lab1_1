package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 * Created by 194974 on 3/7/2017.
 */
public class Money {

    private BigDecimal value;
    private String currency;

    public Money(String currency, BigDecimal value) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }
    public String getCurrency() {
        return currency;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((currency == null) ? 0 : currency.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Money other = (Money) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (currency == null) {
            if (other.currency != null)
                return false;
        } else if (!currency.equals(other.currency))
            return false;
        return true;
    }

    public int compareTo(Money obj) {
        if(currency != null && obj.currency != null && !currency.equalsIgnoreCase(obj.currency)){
            throw new IllegalArgumentException("Niezgodna waluta");
        }
        if (value != null && obj.value !=null){
            return value.compareTo(obj.value);
        }
        return 0;
    }
}
