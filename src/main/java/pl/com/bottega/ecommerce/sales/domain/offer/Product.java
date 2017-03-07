package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author 195086
 */
public class Product {
	private String Id;
	private Money Price;
	private String Name;
	private Date SnapshotDate;
	private String Type;

	public Product(String Id, Money Price, String Name, 
			Date SnapshotDate, String Type) {
		this.Id = Id;
		this.Price = Price;
		this.Name = Name;
		this.SnapshotDate = SnapshotDate;
		this.Type = Type;
	}

	public String getId() {
		return Id;
	}

	public Money getPrice() {
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
