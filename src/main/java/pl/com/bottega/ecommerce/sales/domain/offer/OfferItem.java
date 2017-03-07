/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class OfferItem {
	
	private int quantity;
	private Money totalCost;
	private Product product;

	// discount
	private String discountCause;
	private Money discount;

	public OfferItem(Product product, int quantity) {
		this(product, quantity, null, null);
	}

	public OfferItem(Product product, int quantity, Money discount, String discountCause) {
		this.product = product;
		this.quantity = quantity;
		this.discount = discount;
		this.discountCause = discountCause;

		BigDecimal discountValue = new BigDecimal(0);
		if (discount != null)
			discountValue = discountValue.subtract(discount.value);

		this.totalCost.value = product.price.value.multiply(new BigDecimal(quantity)).subtract(discountValue);
	}

	public Product getProduct() {
		return product;
	}
	
	public Money getTotalCost() {
		return totalCost;
	}

	public Money getDiscount() {
		return discount;
	}

	public String getDiscountCause() {
		return discountCause;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OfferItem other = (OfferItem) obj;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity != other.quantity)
			return false;
		if (totalCost == null) {
			if (other.totalCost != null)
				return false;
		} else if (!totalCost.equals(other.totalCost))
			return false;
		return true;
	}

	/**
	 * 
	 * @param item
	 * @param delta
	 *            acceptable percentage difference
	 * @return
	 */
	public boolean sameAs(OfferItem other, double delta) {
		if (product.name == null) {
			if (other.product.name != null)
				return false;
		} else if (!product.name.equals(other.product.name))
			return false;
		if (product.price == null) {
			if (other.product.price != null)
				return false;
		} else if (!product.price.equals(other.product.price))
			return false;
		if (product.id == null) {
			if (other.product.id != null)
				return false;
		} else if (!product.id.equals(other.product.id))
			return false;
		if (product.type != other.product.type)
			return false;

		if (quantity != other.quantity)
			return false;

		BigDecimal max, min;
		if (totalCost.value.compareTo(other.totalCost.value) > 0) {
			max = totalCost.value;
			min = other.totalCost.value;
		} else {
			max = other.totalCost.value;
			min = totalCost.value;
		}

		BigDecimal difference = max.subtract(min);
		BigDecimal acceptableDelta = max.multiply(new BigDecimal(delta / 100));

		return acceptableDelta.compareTo(difference) > 0;
	}

}
