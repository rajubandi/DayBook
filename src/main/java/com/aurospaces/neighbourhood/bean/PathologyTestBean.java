/**
 * 
 */
package com.aurospaces.neighbourhood.bean;

import org.springframework.stereotype.Component;

/**
 * @author YOGI
 * 
 */
@Component
public class PathologyTestBean {
	private String pathology_id;
	private String pathology_name;
	private String pathology_type;
	private String pathology_description;
	private String pathology_original_price;
	private String pathology_discount_precentage;
	
	/**
	 * @return the pathology_id
	 */
	public String getPathology_id() {
		return pathology_id;
	}

	/**
	 * @param pathology_id
	 *            the pathology_id to set
	 */
	public void setPathology_id(String pathology_id) {
		this.pathology_id = pathology_id;
	}

	/**
	 * @return the pathology_name
	 */
	public String getPathology_name() {
		return pathology_name;
	}

	/**
	 * @param pathology_name
	 *            the pathology_name to set
	 */
	public void setPathology_name(String pathology_name) {
		this.pathology_name = pathology_name;
	}

	/**
	 * @return the pathology_type
	 */
	public String getPathology_type() {
		return pathology_type;
	}

	/**
	 * @param pathology_type
	 *            the pathology_type to set
	 */
	public void setPathology_type(String pathology_type) {
		this.pathology_type = pathology_type;
	}

	/**
	 * @return the pathology_description
	 */
	public String getPathology_description() {
		return pathology_description;
	}

	/**
	 * @param pathology_description
	 *            the pathology_description to set
	 */
	public void setPathology_description(String pathology_description) {
		this.pathology_description = pathology_description;
	}

	/**
	 * @return the pathology_original_price
	 */
	public String getPathology_original_price() {
		return pathology_original_price;
	}

	/**
	 * @param pathology_original_price
	 *            the pathology_original_price to set
	 */
	public void setPathology_original_price(String pathology_original_price) {
		this.pathology_original_price = pathology_original_price;
	}

	/**
	 * @return the pathology_discount_precentage
	 */
	public String getPathology_discount_precentage() {
		return pathology_discount_precentage;
	}

	/**
	 * @param pathology_discount_precentage
	 *            the pathology_discount_precentage to set
	 */
	public void setPathology_discount_precentage(
			String pathology_discount_precentage) {
		this.pathology_discount_precentage = pathology_discount_precentage;
	}

	//

}
