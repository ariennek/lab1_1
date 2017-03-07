package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 * Created by Maciek on 07.03.2017.
 */
public class Money {

    private String currency;
    private BigDecimal amount;

    public Money(String currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
