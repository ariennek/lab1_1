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
    private int quantity;
    private Money totalCost;

    // discount
    private Discount discount;

    public OfferItem(int quantity) {
        this(quantity, null, null);
    }

    public OfferItem(int quantity, BigDecimal discount, String discountCause) {
        this.quantity = quantity;
        this.discount = new Discount(discountCause, new Money(discount,"zl"));

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.subtract(discount);
        }
        
        this.totalCost = new Money(new BigDecimal(0),"zl");
        calculateTotalCost(quantity, discountValue);
    }

    private void calculateTotalCost(int quantity1, BigDecimal discountValue) {
        this.totalCost.setAmount(product.getProductPrice().multiply(new BigDecimal(quantity1)).subtract(discountValue));
    }

    public Product getProduct() {
        return product;
    }
    
    public String getProductId() {
        return product.getProductId();
    }

    public Money getTotalCost() {
        return totalCost;
    }

    public String getTotalCostCurrency() {
        return totalCost.getCurrency();
    }

    public Money getDiscount() {
        return discount.getDiscountAmount();
    }

    public String getDiscountCause() {
        return discount.getCause();
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((discount == null) ? 0 : discount.hashCode());
        result = prime * result + quantity;
        result = prime * result
                + ((totalCost == null) ? 0 : totalCost.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OfferItem other = (OfferItem) obj;
        if (discount == null) {
            if (other.discount != null) {
                return false;
            }
        } else if (!discount.equals(other.discount)) {
            return false;
        }        
        if (quantity != other.quantity) {
            return false;
        }
        if (totalCost == null) {
            if (other.totalCost != null) {
                return false;
            }
        } else if (!totalCost.equals(other.totalCost)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param item
     * @param delta acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max, min;
        if (totalCost.compareTo(other.totalCost) > 0) {
            max = totalCost.getAmount();
            min = other.totalCost.getAmount();
        } else {
            max = other.totalCost.getAmount();
            min = totalCost.getAmount();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(new BigDecimal(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
