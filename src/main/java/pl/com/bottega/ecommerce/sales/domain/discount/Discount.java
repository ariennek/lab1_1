package pl.com.bottega.ecommerce.sales.domain.discount;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import pl.com.bottega.ecommerce.sales.domain.money.Money;

/**
 * Created by grusz on 12.03.2017.
 */
public class Discount {
    private String cause;

    private Money value;

    public Discount(String cause, Money value) {
        this.cause = cause;
        this.value = value;
    }

    public String getCause() {
        return cause;
    }

    public Money getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Discount discount = (Discount) o;

        return new EqualsBuilder()
                .append(cause, discount.cause)
                .append(value, discount.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(cause)
                .append(value)
                .toHashCode();
    }
}