package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 * Created by Maciek on 07.03.2017.
 */
public class Discount {

    private String discountCause;
    private BigDecimal discount;

    Discount(String discountCause, BigDecimal discount) {
        this.discountCause = discountCause;
        this.discount = discount;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public void setDiscountCause(String discountCause) {
        this.discountCause = discountCause;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
