package com.aurospaces.neighbourhood.service;

import java.util.List;

import com.aurospaces.neighbourhood.bean.PathologyOrderBean;
import com.aurospaces.neighbourhood.bean.PathologyTestTypeBean;

public interface PathologyOrderService {
	String insertPathologyOrder(PathologyOrderBean objPathologyOrderBean);
	List<PathologyTestTypeBean> getPathologyType(PathologyTestTypeBean objPathologyTestTypeBean);

}
