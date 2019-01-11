/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import com.aurospaces.neighbourhood.bean.PopulateBean;

/**
 * @author Amith
 *
 */
public interface PopulateDao {
	public List<PopulateBean> populate(String sql);
	public Integer DuplicateCheck(String sql);
}
