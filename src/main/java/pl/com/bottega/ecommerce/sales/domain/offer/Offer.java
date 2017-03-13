package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.ArrayList;
import java.util.List;

public class Offer {
	private List<OfferItem> availableItems = new ArrayList<OfferItem>();

	private List<OfferItem> unavailableItems = new ArrayList<OfferItem>();

	public Offer(List<OfferItem> availableItems, List<OfferItem> unavailableItems) {
		this.setAvailableItems(availableItems);
		this.setUnavailableItems(unavailableItems);
	}

	public List<OfferItem> getUnavailableItems() {
		return unavailableItems;
	}

	public List<OfferItem> getAvailableItems() {
		return availableItems;
	}

	public void setAvailableItems(List<OfferItem> availableItems) {
		this.availableItems = availableItems;
	}

	public void setUnavailableItems(List<OfferItem> unavailableItems) {
		this.unavailableItems = unavailableItems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getAvailableItems() == null) ? 0 : this.getAvailableItems().hashCode());
		result = prime * result + ((this.getUnavailableItems() == null) ? 0 : this.getUnavailableItems().hashCode());
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
		Offer other = (Offer) obj;
		if (this.getAvailableItems() == null) {
			if (other.getAvailableItems() != null)
				return false;
		} else if (!this.getAvailableItems().equals(other.getAvailableItems())) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param seenOffer
	 * @param delta
	 *            acceptable difference in percent
	 * @return
	 */
	public boolean sameAs(Offer seenOffer, double delta) {
		if (!(this.getAvailableItems().size() == seenOffer.getAvailableItems().size()))
			return false;

		for (OfferItem item : this.getAvailableItems()) {
			OfferItem sameItem = seenOffer.findItem(item.getProduct().getProductId());
			if (sameItem == null)
				return false;
			if (!sameItem.sameAs(item, delta))
				return false;
		}

		return true;
	}

	private OfferItem findItem(String productId) {
		for (OfferItem item : this.getAvailableItems()) {
			if (item.getProduct().getProductId().equals(productId))
				return item;
		}
		return null;
	}

}
