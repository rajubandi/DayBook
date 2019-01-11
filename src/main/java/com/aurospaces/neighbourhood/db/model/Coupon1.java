
package com.aurospaces.neighbourhood.db.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import com.aurospaces.neighbourhood.db.basemodel.BaseCoupon1;


@Entity (name = "Coupon1")
public class Coupon1 extends BaseCoupon1
{

	protected BigDecimal discount ;

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	


}
