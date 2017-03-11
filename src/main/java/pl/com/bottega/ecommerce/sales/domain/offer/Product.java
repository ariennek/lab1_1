package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

/**
 * User: Klaudia
 * Date: 11.03.2017
 * Time: 22:52
 */
public class Product {
    private String productId;
    private BigDecimal productPrice;
    private String productName;
    private Date productSnapshotDate;
    private String productType;
    private int quantity;
    private Money money;


    public Product(String productId,
                   BigDecimal productPrice,
                   String productName,
                   Date productSnapshotDate,
                   String productType,
                   int quantity,
                   BigDecimal totalCost,
                   Currency currency) {

        this.productId = productId;
        this.productPrice = productPrice;
        this.productName = productName;
        this.productSnapshotDate = productSnapshotDate;
        this.productType = productType;
        this.quantity = quantity;
        this.money = new Money(totalCost,currency);
    }

    public Product() {

    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public void setProductSnapshotDate(Date productSnapshotDate) {
        this.productSnapshotDate = productSnapshotDate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCost() {
        return money.getTotalCost();
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.money.setTotalCost(totalCost);
    }

    public Currency getCurrency() {
        return this.money.getCurrency();
    }

    public void setCurrency(Currency currency) {
        this.money.setCurrency(currency);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
        result = prime * result + ((productPrice == null) ? 0 : productPrice.hashCode());
        result = prime * result
                + ((productId == null) ? 0 : productId.hashCode());
        result = prime * result + ((productType == null) ? 0 : productType.hashCode());
        result = prime * result + quantity;
        result = prime * result
                + money.hashCode();
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
        Product other = (Product) obj;
        if (productName == null) {
            if (other.productName != null)
                return false;
        } else if (!productName.equals(other.productName))
            return false;
        if (productPrice == null) {
            if (other.productPrice != null)
                return false;
        } else if (!productPrice.equals(other.productPrice))
            return false;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        if (!productType.equals(other.productType))
            return false;
        if (quantity != other.quantity)
            return false;
        if (other.money.equals(this.money)) {
            return false;
        }
        return true;
    }

    public boolean sameAs(Product product, double delta){
        if (productName == null) {
            if (product.productName != null)
                return false;
        } else if (!productName.equals(product.productName))
            return false;
        if (productPrice == null) {
            if (product.productPrice != null)
                return false;
        } else if (!productPrice.equals(product.productPrice))
            return false;
        if (productId == null) {
            if (product.productId != null)
                return false;
        } else if (!productId.equals(product.productId))
            return false;
        if (productType != product.productType)
            return false;

        if (quantity != product.quantity)
            return false;

        BigDecimal max, min;
        if (money.getTotalCost().compareTo(product.money.getTotalCost()) > 0) {
            max = money.getTotalCost();
            min = product.money.getTotalCost();
        } else {
            max = product.money.getTotalCost();
            min = money.getTotalCost();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(new BigDecimal(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;

    }
}
