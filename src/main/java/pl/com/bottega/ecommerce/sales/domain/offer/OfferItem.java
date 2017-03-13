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

	private Discount totalDiscount;

	public OfferItem(Product product, int quantity) {
		this(product, quantity, null);
	}

	public OfferItem(Product product, int quantity, Discount totalDiscount) {
		this.setProduct(product);
		this.setQuantity(quantity);
		this.setTotalDiscount(totalDiscount);

		BigDecimal discountValue = new BigDecimal(0);
		if (totalDiscount != null) {
			discountValue = discountValue.subtract(totalDiscount.getDiscount());
		}

		if (this.getTotalCost() == null) {
			setTotalCost(new Money());
		}

		this.totalCost.setCost(generateTotalCost(product, quantity, discountValue));
	}

	private BigDecimal generateTotalCost(Product product, int quantity, BigDecimal discountValue) {
		return product.getProductPrice().getCost().multiply(new BigDecimal(quantity)).subtract(discountValue);
	}

	public Product getProduct() {
		return product;
	}

	public Money getTotalCost() {
		return totalCost;
	}

	public Discount getTotalDiscount() {
		return totalDiscount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTotalCost(Money totalCost) {
		this.totalCost = totalCost;
	}

	public void setTotalDiscount(Discount totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getTotalDiscount().getDiscount() == null) ? 0
				: this.getTotalDiscount().getDiscount().hashCode());
		result = prime * result + ((this.getProduct() == null) ? 0 : this.getProduct().hashCode());
		result = prime * result + this.getQuantity();
		result = prime * result
				+ ((this.getTotalCost().getCost() == null) ? 0 : this.getTotalCost().getCost().hashCode());
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
		if (this.getTotalDiscount().getDiscount() == null) {
			if (other.getTotalDiscount().getDiscount() != null)
				return false;
		}
		if (this.getProduct() == null) {
			if (other.getProduct() != null)
				return false;
		} else if (!this.getTotalDiscount().getDiscount().equals(other.getTotalDiscount().getDiscount())) {
			return false;
		} else if (!this.getProduct().equals(other.getProduct())) {
			return false;
		}

		if (this.getQuantity() != other.getQuantity())
			return false;
		if (this.getTotalCost().getCost() == null) {
			if (other.getTotalCost().getCost() != null)
				return false;
		} else if (!this.getTotalCost().getCost().equals(other.getTotalCost().getCost()))
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
		if (this.getProduct() == null) {
			if (other.getProduct() != null)
				return false;
		} else if (this.getProduct().getProductName() == null) {
			if (other.getProduct().getProductName() != null)
				return false;
		} else if (!this.getProduct().getProductName().equals(other.getProduct().getProductName()))
			return false;
		if (this.getProduct().getProductPrice() == null) {
			if (other.getProduct().getProductPrice() != null)
				return false;
		} else if (!this.getProduct().getProductPrice().equals(other.getProduct().getProductPrice()))
			return false;
		if (this.getProduct().getProductId() == null) {
			if (other.getProduct().getProductId() != null)
				return false;
		} else if (!this.getProduct().getProductId().equals(other.getProduct().getProductId()))
			return false;
		if (this.getProduct().getProductType() != other.getProduct().getProductType())
			return false;

		if (this.getQuantity() != other.getQuantity())
			return false;

		BigDecimal max, min;
		if (this.getTotalCost().getCost().compareTo(other.getTotalCost().getCost()) > 0) {
			max = this.getTotalCost().getCost();
			min = other.getTotalCost().getCost();
		} else {
			max = other.getTotalCost().getCost();
			min = this.getTotalCost().getCost();
		}

		BigDecimal difference = max.subtract(min);
		BigDecimal acceptableDelta = max.multiply(new BigDecimal(delta / 100));

		return acceptableDelta.compareTo(difference) > 0;
	}

}
