package pl.com.bottega.ecommerce.sales.domain.product;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by grusz on 07.03.2017.
 */
public class Product {

    private String Id;

    private BigDecimal price;

    private String name;

    private Date snapshotDate;

    private ProductType type;

    public Product(String productId, BigDecimal productPrice, String productName, Date snapshotDate,
            ProductType type) {
        this.Id = productId;
        this.price = productPrice;
        this.name = productName;
        this.snapshotDate = snapshotDate;
        this.type = type;
    }


    public String getId() {
        return Id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public ProductType getType() {
        return type;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Product product = (Product) o;

        return new EqualsBuilder().append(Id, product.Id).append(price, product.price)
                .append(name, product.name).append(snapshotDate, product.snapshotDate)
                .append(type, product.type).isEquals();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder(17, 37).append(Id).append(price).append(name)
                .append(snapshotDate).append(type).toHashCode();
    }
}
