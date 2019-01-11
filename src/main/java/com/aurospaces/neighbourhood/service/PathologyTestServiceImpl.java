/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.PathologyBean;
import com.aurospaces.neighbourhood.bean.PathologyTestBean;
import com.aurospaces.neighbourhood.dao.PathologyTestDao;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;

/**
 * @author Divya
 * @param <objPathologyDao>
 * 
 */
@Service
public class PathologyTestServiceImpl implements PathologyTestService {
	@Autowired
	PathologyTestDao objPathologyDao;

	@Override
	public boolean insertPathology(PathologyBean objPathologyBean) {
		boolean isPathologyInsert = false;
		try {
			String sPathologyId = new NeighbourhoodUtil().getGUId();
			if (sPathologyId != null) {
				objPathologyBean.setTestName(sPathologyId);
			}
			isPathologyInsert = objPathologyDao.insertPathology(objPathologyBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isPathologyInsert;
	}

	@Override
	public boolean updatePathology(PathologyBean objPathologyBean) {
		boolean isPathologyUpdate = false;
		try {
			isPathologyUpdate = objPathologyDao.updatePathology(objPathologyBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isPathologyUpdate;
	}

	@Override
	public List<PathologyTestBean> getPathologys(PathologyTestBean objPathologyBean, String likeSearch) {
		List<PathologyTestBean> listPathologyBeans = null;
		try {
			listPathologyBeans = objPathologyDao.getPathologys(objPathologyBean, likeSearch);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listPathologyBeans;
	}

	@Override
	public PathologyBean getPathology(PathologyBean objPathologyBean, String likeSearch) {
		PathologyBean objEditPathologyBean = null;
		try {
			objEditPathologyBean = objPathologyDao.getPahtology(objPathologyBean, likeSearch);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objEditPathologyBean;
	}

	@Override
	public boolean deletePathology(PathologyBean objPathologyBean) {
		boolean isPathologyDelete = false;
		try {
			isPathologyDelete = objPathologyDao.deletePathology(objPathologyBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isPathologyDelete;
	}

}
	