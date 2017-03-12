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
public class Money {    
    private BigDecimal amount;
    private String Currency;
    
    public Money(BigDecimal amount, String Currency) {
        this.amount = amount;
        this.Currency = Currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String Currency) {
        this.Currency = Currency;
    }    
    
    public int compareTo(Object obj) {
        Money mon = (Money) obj;
        return this.amount.compareTo(mon.getAmount());
    }
}
