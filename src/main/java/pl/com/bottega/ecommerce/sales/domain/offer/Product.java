package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;

public class Product {
	public String id;

	public Money price;
	
	public String name;

	public Date snapshotDate;

	public String type;
	
	public Product(String productId, Money productPrice, String productName, Date productSnapshotDate, String productType) {
		this.id = productId;
		this.price = productPrice;
		this.name = productName;
		this.snapshotDate = productSnapshotDate;
		this.type = productType;
	}
}
