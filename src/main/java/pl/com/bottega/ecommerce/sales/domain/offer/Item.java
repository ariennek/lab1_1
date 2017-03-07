package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 195035 on 3/7/2017.
 */
public class Item {
    public final String productId;

    public final BigDecimal productPrice;

    public final String productName;

    public final Date productSnapshotDate;

    public final String productType;

    public Item(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate, String productType) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.productName = productName;
        this.productSnapshotDate = productSnapshotDate;
        this.productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (productId != null ? !productId.equals(item.productId) : item.productId != null) return false;
        if (productPrice != null ? !productPrice.equals(item.productPrice) : item.productPrice != null) return false;
        if (productName != null ? !productName.equals(item.productName) : item.productName != null) return false;
        if (productSnapshotDate != null ? !productSnapshotDate.equals(item.productSnapshotDate) : item.productSnapshotDate != null)
            return false;
        return productType != null ? productType.equals(item.productType) : item.productType == null;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productSnapshotDate != null ? productSnapshotDate.hashCode() : 0);
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        return result;
    }
}
