package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money {
	public String currency;
	
	public BigDecimal value;
	
	Money(BigDecimal value, String currency) {
		this.value = value;
		this.currency = currency;
	}
	
}
