/**
 * 
 */
package com.aurospaces.neighbourhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.TypeBean;
import com.aurospaces.neighbourhood.dao.TypeDao;
import com.aurospaces.neighbourhood.util.NeighbourhoodUtil;

/**
 * @author Divya
 * 
 */
@Service
public class TypeServiceImpl implements TypeService {
	@Autowired
	TypeDao objTypeDao;

	@Override
	public boolean insertType(TypeBean objTypeBean) {
		boolean isTypeInsert = false;
		try {
			String sTypeId = new NeighbourhoodUtil().getGUId();
			if (sTypeId != null) {
				objTypeBean.setTypeId(sTypeId);
			}
			isTypeInsert = objTypeDao.insertType(objTypeBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isTypeInsert;
	}

	@Override
	public boolean updateType(TypeBean objTypeBean) {
		boolean isTypeUpdate = false;
		try {
			isTypeUpdate = objTypeDao.updateType(objTypeBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isTypeUpdate;
	}

	@Override
	public List<TypeBean> getTypes(TypeBean objTypeBean, String likeSearch) {
		List<TypeBean> listTypeBeans = null;
		try {
			listTypeBeans = objTypeDao.getTypes(objTypeBean, likeSearch);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listTypeBeans;
	}

	@Override
	public TypeBean getType(TypeBean objTypeBean, String likeSearch) {
		TypeBean objEditTypeBean = null;
		try {
			objEditTypeBean = objTypeDao.getType(objTypeBean, likeSearch);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return objEditTypeBean;
	}

	@Override
	public boolean deleteType(TypeBean objTypeBean) {
		boolean isTypeDelete = false;
		try {
			isTypeDelete = objTypeDao.deleteType(objTypeBean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return isTypeDelete;
	}
}