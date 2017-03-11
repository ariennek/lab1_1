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
import java.util.Date;

public class OfferItem {

	private Product product;
	private Discount discount;
	private Money totalCost;
	private int quantity;

	public OfferItem(Product product, Discount discount, int quantity, String currency) {
			this.discount = discount;
			this.product = product;
			this.totalCost = new Money(currency, calculateOfferTotalCost());
			this.quantity = quantity;
	}

	private BigDecimal calculateOfferTotalCost() {
		BigDecimal discountValue = this.discount.calculateDiscountValue();
		return this.product.getProductPrice().getAmount().multiply(new BigDecimal(quantity)).subtract(discountValue);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((product.getProductName()== null) ? 0 : product.getProductName().hashCode());
		result = prime * result + ((product.getProductPrice() == null) ? 0 : product.getProductPrice().hashCode());
		result = prime * result
				+ ((product.getProductId() == null) ? 0 : product.getProductId().hashCode());
		result = prime * result + ((product.getProductType() == null) ? 0 : product.getProductType().hashCode());
		result = prime * result + quantity;
		result = prime * result
				+ ((totalCost == null) ? 0 : totalCost.hashCode());
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
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productPrice == null) {
			if (other.productPrice != null)
				return false;
		} else if (!productPrice.equals(other.productPrice))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productType != other.productType)
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
		if (this.product.getProductName() == null) {
			if (other.getProduct().getProductName() != null)
				return false;
		} else if (!this.product.getProductName().equals(other.product.getProductName()))
			return false;
		if (this.getProduct().getProductPrice() == null) {
			if (other.product.getProductPrice()!= null)
				return false;
		} else if (!this.getProduct().getProductPrice().equals(other.getProduct().getProductPrice()))
			return false;
		if (this.getProduct().getProductId()== null) {
			if (other.getProduct().getProductId()!= null)
				return false;
		} else if (!this.getProduct().getProductId().equals(other.getProduct().getProductId()))
			return false;
		if (this.getProduct().getProductType()!= other.getProduct().getProductType())
			return false;

		if (quantity != other.quantity)
			return false;

		BigDecimal max, min;
		if (totalCost.compareTo(other.totalCost) > 0) {
			max = totalCost;
			min = other.totalCost;
		} else {
			max = other.totalCost;
			min = totalCost;
		}

		BigDecimal difference = max.subtract(min);
		BigDecimal acceptableDelta = max.multiply(new BigDecimal(delta / 100));

		return acceptableDelta.compareTo(difference) > 0;
	}

	public Product getProduct() {
		return product;
	}
}
