package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 * Created by Piotr on 07.03.2017.
 */
public class Money {

    private String currency;
    private BigDecimal amount;

    public Money(String currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
