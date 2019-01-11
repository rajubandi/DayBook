/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import com.aurospaces.neighbourhood.bean.TypeBean;

/**
 * @author sandhya
 *
 */
public interface TypeDao {
	boolean insertType(TypeBean objTypeBean);
	boolean updateType(TypeBean objTypeBean);
	List<TypeBean> getTypes(TypeBean objTypeBean, String likeSearch);
	TypeBean getType(TypeBean objTypeBean, String likeSearch);
	boolean deleteType(TypeBean objTypeBean);
}
