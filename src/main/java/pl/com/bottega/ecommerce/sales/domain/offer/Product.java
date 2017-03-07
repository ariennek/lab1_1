package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Piotr on 07.03.2017.
 */
public class Product {
    // product
    private String productId;

    private BigDecimal productPrice;

    private String productName;

    private Date productSnapshotDate;

    private String productType;

    private int quantity;

    private BigDecimal totalCost;


    public Product(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate,
            String productType, int quantity, BigDecimal totalCost) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.productName = productName;
        this.productSnapshotDate = productSnapshotDate;
        this.productType = productType;
        this.quantity = quantity;
        this.totalCost = totalCost;
    }
}
