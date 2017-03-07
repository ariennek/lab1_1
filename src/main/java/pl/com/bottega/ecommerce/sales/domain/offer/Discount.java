package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 * Created by 194974 on 3/7/2017.
 */
public class Discount {

    private String discountCause;

    private BigDecimal discountAmount;

    public String getDiscountCause() {
        return discountCause;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((discountAmount == null) ? 0 : discountAmount.hashCode());
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
        Discount other = (Discount) obj;
        if (discountAmount == null) {
            if (other.discountAmount != null)
                return false;
        } else if (!discountAmount.equals(other.discountAmount))
            return false;
        return true;
    }
}
