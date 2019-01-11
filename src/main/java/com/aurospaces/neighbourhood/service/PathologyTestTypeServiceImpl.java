/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.PathologyTestTypeBean;
import com.aurospaces.neighbourhood.dao.PathologyTestTypeDao;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;

/**
 * @author Divya
 * 
 */
@Service
public class PathologyTestTypeServiceImpl implements PathologyTestTypeService {
	@Autowired
	PathologyTestTypeDao objPathologyTestTypeDao;

	@Override
	public boolean insertPathologyTestType(PathologyTestTypeBean objPathologyTestTypeBean) {
		boolean isPathologyTestTypeInsert = false;
		try {
			String sPathologyTestTypeId = new NeighbourhoodUtil().getGUId();
			if (sPathologyTestTypeId != null) {
				objPathologyTestTypeBean.setTestTypeId(sPathologyTestTypeId);
			}
			isPathologyTestTypeInsert = objPathologyTestTypeDao.insertPathologyTestType(objPathologyTestTypeBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isPathologyTestTypeInsert;
	}

	@Override
	public boolean updatePathologyTestType(PathologyTestTypeBean objPathologyTestTypeBean) {
		boolean isPathologyTestTypeUpdate = false;
		try {
			isPathologyTestTypeUpdate = objPathologyTestTypeDao.updatePathologyTestType(objPathologyTestTypeBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isPathologyTestTypeUpdate;
	}

	@Override
	public List<PathologyTestTypeBean> getPathologyTestTypes(PathologyTestTypeBean objPathologyTestTypeBean, String likeSearch) {
		List<PathologyTestTypeBean> listPathologyTestTypeBeans = null;
		try {
			listPathologyTestTypeBeans = objPathologyTestTypeDao.getPathologyTestTypes(objPathologyTestTypeBean, likeSearch);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listPathologyTestTypeBeans;
	}

	@Override
	public PathologyTestTypeBean getPathologyTestType(PathologyTestTypeBean objPathologyTestTypeBean, String likeSearch) {
		PathologyTestTypeBean objEditPathologyTestTypeBean = null;
		try {
			objEditPathologyTestTypeBean = objPathologyTestTypeDao.getPathologyTestType(objPathologyTestTypeBean, likeSearch);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objEditPathologyTestTypeBean;
	}

	@Override
	public boolean deletePathologyTestType(PathologyTestTypeBean objPathologyTestTypeBean) {
		boolean isPathologyTestTypeDelete = false;
		try {
			isPathologyTestTypeDelete = objPathologyTestTypeDao.deletePathologyTestType(objPathologyTestTypeBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isPathologyTestTypeDelete;
	}
}