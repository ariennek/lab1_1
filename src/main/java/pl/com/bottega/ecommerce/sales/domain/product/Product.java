package pl.com.bottega.ecommerce.sales.domain.product;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import pl.com.bottega.ecommerce.sales.domain.money.Money;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by grusz on 07.03.2017.
 */
public class Product {

    private String Id;

    private Money value;

    private String name;

    private Date snapshotDate;

    private ProductType type;

    public Product(String Id, Money value, String name, Date snapshotDate,
            ProductType type) {
        this.Id = Id;
        this.value = value;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;
    }


    public String getId() {
        return Id;
    }

    public Money getValue() {
        return value;
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

        return new EqualsBuilder().append(Id, product.Id).append(value, product.value)
                .append(name, product.name).append(snapshotDate, product.snapshotDate)
                .append(type, product.type).isEquals();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder(17, 37).append(Id).append(value).append(name)
                .append(snapshotDate).append(type).toHashCode();
    }
}
