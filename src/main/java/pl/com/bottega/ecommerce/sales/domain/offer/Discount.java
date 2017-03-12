package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 * Created by pebuls on 07.03.17.
 */
public class Discount {

    private String discountCause;
    private BigDecimal discount;
    private BigDecimal discountValue = new BigDecimal(0);

    public Discount(BigDecimal discount, String discountCause) {

        this.discount = discount;
        this.discountCause = discountCause;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public BigDecimal getDiscountValue () {
        if (getDiscount() != null) discountValue = discountValue.subtract(getDiscount());
        return discountValue;
    }
}
