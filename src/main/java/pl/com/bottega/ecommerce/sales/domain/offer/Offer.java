package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.ArrayList;
import java.util.List;

public class Offer {
	private List<OfferItem> items = new ArrayList<OfferItem>();


	public Offer(List<OfferItem> items) {
		this.items=items;

	}

	public List<OfferItem> getAvailabeItems() {
		return new ArrayList<OfferItem>();
		//implement this
	}

	public List<OfferItem> getUnavailableItems() {
		return new ArrayList<OfferItem>();
		//implement this
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getAvailabeItems() == null) ? 0 : getAvailabeItems().hashCode());
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
		if (getAvailabeItems() == null) {
			if (other.getAvailabeItems() != null)
				return false;
		} else if (!getAvailabeItems().equals(other.getAvailabeItems()))
			return false;
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
		if (!(getAvailabeItems().size() == seenOffer.getAvailabeItems().size()))
			return false;

		for (OfferItem item : getAvailabeItems()) {
			OfferItem sameItem = seenOffer.findItem(item.getProduct().getProductId());
			if (sameItem == null)
				return false;
			if (!sameItem.sameAs(item, delta))
				return false;
		}

		return true;
	}

	private OfferItem findItem(String productId) {
		for (OfferItem item : getAvailabeItems()) {
			if (item.getProduct().getProductId().equals(productId))
				return item;
		}
		return null;
	}

}
