
package com.aurospaces.neighbourhood.db.model;

import javax.persistence.Entity;
import com.aurospaces.neighbourhood.db.basemodel.BaseCoupon;

@Entity(name = "Coupon")
public class Coupon extends BaseCoupon {
	public String couponId;

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

}
