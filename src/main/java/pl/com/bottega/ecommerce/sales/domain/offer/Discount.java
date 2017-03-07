package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 * Created by Maciek on 07.03.2017.
 */
public class Discount {

    private String discountCause;
    private Money money;

    Discount(String discountCause, Money money) {
        this.discountCause = discountCause;
        this.money = money;
    }

    BigDecimal calculateDiscountValue() {

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.subtract(discount);
        }
        return discountValue;
    }
}
