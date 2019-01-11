package com.aurospaces.neighbourhood.dao;

import java.util.*;

import com.aurospaces.neighbourhood.bean.PathologyOrderBean;
import com.aurospaces.neighbourhood.bean.PathologyTestTypeBean;

public interface PathologyOrderDao {
	public String insertPathologyOrder(PathologyOrderBean objPathologyOrderBean);
	List<PathologyTestTypeBean> getPathologyType(PathologyTestTypeBean objPathologyTestTypeBean);

}
