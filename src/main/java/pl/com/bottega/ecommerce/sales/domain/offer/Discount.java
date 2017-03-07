package pl.com.bottega.ecommerce.sales.domain.offer;

/**
 *
 * @author 195086
 */
public class Discount {
	private Money discount;
	private String discountCause;

	public Discount(Money discount, String discountCause) {
		this.discount = discount;
		this.discountCause = discountCause;
	}

	public Discount(Money discount) {
		this(discount, null);
	}

	public Money getDiscount() {
		return discount;
	}

	public String getDiscountCause() {
		return discountCause;
	}
	
}
