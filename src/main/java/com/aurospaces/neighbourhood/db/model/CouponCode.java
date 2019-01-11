
package com.aurospaces.neighbourhood.db.model;

import javax.persistence.Entity;
import com.aurospaces.neighbourhood.db.basemodel.BaseCouponCode;

@Entity(name = "CouponCode")
public class CouponCode extends BaseCouponCode {
	public String partnerId;
	public String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
}
