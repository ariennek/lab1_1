package pl.com.bottega.ecommerce.sales.domain.product;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by grusz on 07.03.2017.
 */
public class Product {

    private String productId;

    private BigDecimal productPrice;

    private String productName;

    private Date productSnapshotDate;

    private String productType;

    public Product(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate,
            String productType) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.productName = productName;
        this.productSnapshotDate = productSnapshotDate;
        this.productType = productType;
    }


    public String getProductId() {
        return productId;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public String getProductType() {
        return productType;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Product product = (Product) o;

        return new EqualsBuilder().append(productId, product.productId).append(productPrice, product.productPrice)
                .append(productName, product.productName).append(productSnapshotDate, product.productSnapshotDate)
                .append(productType, product.productType).isEquals();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder(17, 37).append(productId).append(productPrice).append(productName)
                .append(productSnapshotDate).append(productType).toHashCode();
    }
}
