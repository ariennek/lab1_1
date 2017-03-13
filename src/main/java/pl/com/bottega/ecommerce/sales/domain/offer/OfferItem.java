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

import pl.com.bottega.ecommerce.sales.domain.discount.Discount;
import pl.com.bottega.ecommerce.sales.domain.money.Money;
import pl.com.bottega.ecommerce.sales.domain.product.Product;

import java.math.BigDecimal;

public class OfferItem {

    // product
    private Product product;

    private int quantity;

    private Money totalCost;

    private Money value;

    // discount


    private Discount discount;

    public OfferItem(Product product, int quantity) {
        this(product, quantity, null);
    }

    public OfferItem(Product product, int quantity, Discount discount) {

        this.quantity = quantity;
        this.discount = discount;

        Money discountValue = new Money(0);
        if (discount != null)
            discountValue = discount.getValue();

        this.totalCost = product.getValue().multiply(new BigDecimal(quantity)).substract(discountValue);
    }



    public Money getTotalCost() {
        return totalCost;
    }

    public String getCurrency() {
        return value.getCurrency().getCurrencyCode();
    }

    public Discount getDiscount() {
        return discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    @Override public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((discount == null) ? 0 : discount.hashCode());
        result = prime * result + ((product == null) ? 0 : product.hashCode());
        result = prime * result + quantity;
        result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
        return result;
    }

    @Override public boolean equals(Object obj) {
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




}
