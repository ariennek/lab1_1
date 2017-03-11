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

    public OfferItem(String productId, BigDecimal productPrice, String productName,
                     Date productSnapshotDate, String productType, int quantity) {
        this(productId, productPrice, productName, productSnapshotDate, productType, quantity, null, null);
    }

    public OfferItem(String productId, BigDecimal productPrice, String productName,
                     Date productSnapshotDate, String productType, int quantity,
                     BigDecimal discount, String discountCause) {

        this.discount = new Discount(discountCause,discount);


        BigDecimal totalCost = productPrice
                .multiply(new BigDecimal(quantity)).subtract(this.discount.getDiscountValue());
        this.product = new Product(productId, productPrice, productName, productSnapshotDate, productType, quantity, totalCost, null);
    }



    @Override
    public int hashCode() {
       int result;
        result = product.hashCode() + discount.hashCode();
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
        if(other.product.equals(this.product)){
            return true;
        }
        return false;
    }

    /**
     * @param other
     * @param delta acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
       return this.product.sameAs(other.product, delta);
    }

}
