package pl.com.bottega.ecommerce.sales.domain.offer;

class Discount {
	
	public Money discount;
	public String discountCause;
	
	public Discount(String discountCause, Money discount) {
		this.discountCause = discountCause;
		this.discount = discount;
	}
}
