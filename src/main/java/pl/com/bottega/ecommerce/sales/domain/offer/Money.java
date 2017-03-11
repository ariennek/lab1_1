package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

class Money {
	
	public String currency;
	public BigDecimal value;
	
	public Money(BigDecimal value, String currency) {
		this.value = value;
		this.currency = currency;
	}
}
