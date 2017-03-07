package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 * Created by pebuls on 07.03.17.
 */
public class Discount {

    private String discountCause;
    private BigDecimal discount;

    public Discount(BigDecimal discount, String discountCause) {

        this.discount = discount;
        this.discountCause = discountCause;

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null)discountValue = discountValue.subtract(discount);
    }
}
