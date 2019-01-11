package com.aurospaces.neighbourhood.service;

import java.util.List;

import com.aurospaces.neighbourhood.bean.PathologyDetailsBean;
import com.aurospaces.neighbourhood.bean.PathologyOrderInfoBean;

public interface PathologyOrderInfoService {
	
	String getPathologyOrderInfo(PathologyOrderInfoBean objPathologyOrderInfoBean);
	boolean getPathologyDetails(List<PathologyDetailsBean> objPathologyAddBean,
			String pathologyId);
	boolean insertPathologyOrderInfo(PathologyOrderInfoBean objPathologyOrderInfoBean);

}
