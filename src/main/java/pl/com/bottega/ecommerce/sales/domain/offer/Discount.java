package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
	private String discountCause;
	private BigDecimal discount;
	private String currency;
	
	public Discount() {
	}

	public String getDiscountCause() {
		return discountCause;
	}

	public void setDiscountCause(String discountCause) {
		this.discountCause = discountCause;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	
	public void setCurrency(String currency){
		this.currency=currency;
	}
	
	public String getCurrency(){
		return currency;
	}
}