
package com.aurospaces.neighbourhood.service;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurospaces.neighbourhood.bean.PopulateBean;
import com.aurospaces.neighbourhood.dao.PopulateDao;

/**
 * @author Amith
 * 
 */
@Service("populateService")
public class PopulateServiceImpl implements PopulateService {
	@Autowired
	PopulateDao dao;
	private Logger logger = Logger.getLogger(PopulateServiceImpl.class);

	@Override
	public List<PopulateBean> populate(String sSql) {
		List<PopulateBean> list = null;
		try {
			list = dao.populate(sSql);
		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.fatal("error in populate in PopulateServiceImpl");
		} finally {

		}
		return list;
	}

	@Override
	public Map<String, String> populatePopUp(String sSql) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		List<PopulateBean> list = null;

		try {
			list = dao.populate(sSql);
			Iterator<PopulateBean> iterator = list.iterator();
			while (iterator.hasNext()) {
				PopulateBean objects = (PopulateBean) iterator.next();
				map.put(objects.getId(), objects.getName());
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.fatal("error in populatePopUp in PopulateServiceImpl");
		} finally {

		}
		return map;

	}

	
}
