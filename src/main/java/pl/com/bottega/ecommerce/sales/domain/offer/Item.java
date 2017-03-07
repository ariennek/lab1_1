package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 195035 on 3/7/2017.
 */
public class Item {
    public final String id;

    public final BigDecimal price;

    public final String name;

    public final Date snapshotDate;

    public final String type;

    public Item(String id, BigDecimal price, String name, Date snapshotDate, String type) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != null ? !id.equals(item.id) : item.id != null) return false;
        if (price != null ? !price.equals(item.price) : item.price != null) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (snapshotDate != null ? !snapshotDate.equals(item.snapshotDate) : item.snapshotDate != null)
            return false;
        return type != null ? type.equals(item.type) : item.type == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (snapshotDate != null ? snapshotDate.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
