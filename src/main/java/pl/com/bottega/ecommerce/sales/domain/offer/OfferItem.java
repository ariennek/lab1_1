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

	private Product product;

	private int quantity;

	private Money totalCost;

	// discount
	private String discountCause;

	private BigDecimal discount;

	public OfferItem(Product product, int quantity) {
		this(product, quantity, null, null);
	}

	public OfferItem(Product product, int quantity, BigDecimal discount, String discountCause) {
		this.product = product;
		this.quantity = quantity;
		this.discount = discount;
		this.discountCause = discountCause;

		BigDecimal discountValue = new BigDecimal(0);
		if (discount != null)
			discountValue = discountValue.subtract(discount);

		this.totalCost.setCost(product.getProductPrice().getCost().multiply(new BigDecimal(quantity)).subtract(discountValue));
	}

	public Product getProduct() {
		return product;
	}
	
	public Money getTotalCost() {
		return totalCost;
	}

	public BigDecimal getDiscount() {
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
		result = prime * result + ((totalCost.getCost() == null) ? 0 : totalCost.getCost().hashCode());
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
		}
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!discount.equals(other.discount)) {
			return false;
		} else if (!product.equals(other.product)) {
			return false;
		}

		if (quantity != other.quantity)
			return false;
		if (totalCost.getCost() == null) {
			if (other.totalCost.getCost() != null)
				return false;
		} else if (!totalCost.getCost().equals(other.totalCost.getCost()))
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
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (product.getProductName() == null) {
			if (other.product.getProductName() != null)
				return false;
		} else if (!product.getProductName().equals(other.product.getProductName()))
			return false;
		if (product.getProductPrice() == null) {
			if (other.product.getProductPrice() != null)
				return false;
		} else if (!product.getProductPrice().equals(other.product.getProductPrice()))
			return false;
		if (product.getProductId() == null) {
			if (other.product.getProductId() != null)
				return false;
		} else if (!product.getProductId().equals(other.product.getProductId()))
			return false;
		if (product.getProductType() != other.product.getProductType())
			return false;

		if (quantity != other.quantity)
			return false;

		BigDecimal max, min;
		if (totalCost.getCost().compareTo(other.totalCost.getCost()) > 0) {
			max = totalCost.getCost();
			min = other.totalCost.getCost();
		} else {
			max = other.totalCost.getCost();
			min = totalCost.getCost();
		}

		BigDecimal difference = max.subtract(min);
		BigDecimal acceptableDelta = max.multiply(new BigDecimal(delta / 100));

		return acceptableDelta.compareTo(difference) > 0;
	}

}
