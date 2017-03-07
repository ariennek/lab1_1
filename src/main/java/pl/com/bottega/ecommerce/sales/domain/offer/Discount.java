package pl.com.bottega.ecommerce.sales.domain.offer;

/**
 * Created by 195035 on 3/7/2017.
 */
public class Discount {

    public final String cause;
    public final Money value;

    public Discount(String cause, Money value) {
        this.cause = cause;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discount discount = (Discount) o;

        return (cause != null ? cause.equals(discount.cause) : discount.cause == null) && (value != null ? value.equals(discount.value) : discount.value == null);
    }

    @Override
    public int hashCode() {
        int result = cause != null ? cause.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
