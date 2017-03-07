/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author 195059
 */
public class Product {

    private String id;
    private BigDecimal price;
    private String name;
    private Date snapshotDate;
    private String type;

    public Product(String productId, BigDecimal productPrice, String productName,
            Date productSnapshotDate, String productType) {
        this.id = productId;
        this.price = productPrice;
        this.name = productName;
        this.snapshotDate = productSnapshotDate;
        this.type = productType;
    }

    public String getProductId() {
        return id;
    }

    public BigDecimal getProductPrice() {
        return price;
    }

    public String getProductName() {
        return name;
    }

    public Date getProductSnapshotDate() {
        return snapshotDate;
    }

    public String getProductType() {
        return type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result
                + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        Product other = (Product) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (price == null) {
            if (other.price != null) {
                return false;
            }
        } else if (!price.equals(other.price)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (type != other.type) {
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
    public boolean sameAs(Product other, double delta) {
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (price == null) {
            if (other.price != null) {
                return false;
            }
        } else if (!price.equals(other.price)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (type != other.type) {
            return false;
        }
        return true;
    }

}
