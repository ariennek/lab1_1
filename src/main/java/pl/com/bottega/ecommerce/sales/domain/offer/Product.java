package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by pebuls on 07.03.17.
 */
public class Product {

    private String id;

    private BigDecimal price;

    private String name;

    private Date snapshotDate;

    private String type;

    public Product(String id, BigDecimal price, String name, Date snapshotDate, String type) {

        this.id = id;
        this.price = price;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;
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
}
