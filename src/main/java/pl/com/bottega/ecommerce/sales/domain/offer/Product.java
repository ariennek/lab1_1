package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author 195086
 */
public class Product {
	private String Id;
	private BigDecimal Price;
	private String Name;
	private Date SnapshotDate;
	private String Type;

	public Product(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate, String productType) {
		this.Id = productId;
		this.Price = productPrice;
		this.Name = productName;
		this.SnapshotDate = productSnapshotDate;
		this.Type = productType;
	}

	public String getId() {
		return Id;
	}

	public BigDecimal getPrice() {
		return Price;
	}

	public String getName() {
		return Name;
	}

	public Date getSnapshotDate() {
		return SnapshotDate;
	}

	public String getType() {
		return Type;
	}
	
}
