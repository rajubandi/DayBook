/**
 * 
 */
package com.aurospaces.neighbourhood.custommodel;

/**
 * @author yogi
 *
 */
public class FeedbackAPI {
	public String email_id_or_mobile_no;
	public String order_id;
	public String happy_rating;
	public String happy_comments;

	public String getEmail_id_or_mobile_no() {
		return email_id_or_mobile_no;
	}

	public void setEmail_id_or_mobile_no(String email_id_or_mobile_no) {
		this.email_id_or_mobile_no = email_id_or_mobile_no;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getHappy_rating() {
		return happy_rating;
	}

	public void setHappy_rating(String happy_rating) {
		this.happy_rating = happy_rating;
	}

	public String getHappy_comments() {
		return happy_comments;
	}

	public void setHappy_comments(String happy_comments) {
		this.happy_comments = happy_comments;
	}

}
