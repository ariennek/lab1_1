/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 *
 * @author 195059
 */
public class Discount {
    private String cause;
    private Money discountAmount;

    public Discount(String cause, Money discountAmount) {
        this.cause = cause;
        this.discountAmount = discountAmount;
    }

    public String getCause() {
        return cause;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }    
    
}
