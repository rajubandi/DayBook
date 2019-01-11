/**
 * 
 */
package com.aurospaces.neighbourhood.dao;

import java.util.List;

import com.aurospaces.neighbourhood.bean.PathologyBean;
import com.aurospaces.neighbourhood.bean.PathologyTestBean;

/**
 * @author Divya
 *
 */
public interface PathologyTestDao {
	boolean insertPathology(PathologyBean objPathologyBean);
	boolean updatePathology(PathologyBean objPathologyBean);
	List<PathologyTestBean> getPathologys(PathologyTestBean objPathologyBean, String likeSearch);
	PathologyBean getPahtology(PathologyBean objPathologyBean, String likeSearch);
	boolean deletePathology(PathologyBean objPathologyBean);

}
