package pl.com.bottega.ecommerce.sales.domain.offer;

public class Discount {
	public String discountCause;

	public Money discount;
	
	Discount(String discountCause, Money discount) {
		this.discountCause = discountCause;
		this.discount = discount;
	}
}
