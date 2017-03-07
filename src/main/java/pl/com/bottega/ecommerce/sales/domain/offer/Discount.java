package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 * Created by Piotr on 07.03.2017.
 */
public class Discount {
    // discount
    private String discountCause;

    private BigDecimal discount;

    public Discount(String discountCause, BigDecimal discount) {
        this.discountCause = discountCause;
        this.discount = discount;
    }
}
