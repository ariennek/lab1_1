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

	private final Item item;

	private final int quantity;

	private final Money totalCost;

	// discount
	private Discount discount;

	public OfferItem(Item item, int quantity) {
		this(item, quantity, null);
	}

	public OfferItem(Item item, int quantity, Discount discount) {
		this.item = item;

		this.quantity = quantity;
		this.discount = discount;

		if(item.price != null && discount.value != null && !item.price.currency.equals(discount.value.currency)) {
		    throw new IllegalArgumentException("Currency mismatch");
        }

		BigDecimal discountValue = new BigDecimal(0);
		if (discount != null && discount.value != null)
			discountValue = discountValue.subtract(discount.value.value);

		this.totalCost = new Money(item.price.currency, item.price.value.multiply(new BigDecimal(quantity)).subtract(discountValue));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + item.hashCode();
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
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
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

    public Item getItem() {
        return item;
    }

    /**
	 * 
	 * @param other OfferItem to compare
	 * @param delta
	 *            acceptable percentage difference
	 * @return true if offer is same as other and false otherwise
	 */
	public boolean sameAs(OfferItem other, double delta) {
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;

		if (quantity != other.quantity)
			return false;

		Money max, min;
		if (totalCost.compareTo(other.totalCost) > 0) {
			max = totalCost;
			min = other.totalCost;
		} else {
			max = other.totalCost;
			min = totalCost;
		}

		BigDecimal difference = max.value.subtract(min.value);
		BigDecimal acceptableDelta = max.value.multiply(new BigDecimal(delta / 100));

		return acceptableDelta.compareTo(difference) > 0;
	}

}
