package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

/**
 *
 * @author 195086
 */
public class Money implements Comparable{
	private BigDecimal value;
	private String currency;

	public Money(BigDecimal value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	public Money(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getValue() {
		return value;
	}

	public String getCurrency() {
		return currency;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int compareTo(Object o) {
		Money other = (Money) o;
		return this.value.compareTo(other.getValue());
	}
	
}
