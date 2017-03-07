package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 * Created by Piotr on 07.03.2017.
 */
public class Discount {
    // discount
    private String discountCause;

//    private BigDecimal discount;
    private Money discount;

    public Discount(String discountCause, Money discount) {
        this.discountCause = discountCause;
        this.discount = discount;
    }

    public BigDecimal calculateDiscountValue () {
        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.subtract(discount.getAmount());
        }
        return discountValue;
    }
}
