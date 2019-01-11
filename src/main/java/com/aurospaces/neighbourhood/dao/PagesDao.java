package com.aurospaces.neighbourhood.dao;

import java.util.List;

import com.aurospaces.neighbourhood.bean.PagesBean;

public interface PagesDao {
	 boolean insertPages(PagesBean objPagesBean);
	 List<PagesBean> getServices(PagesBean objPagesBean,String likeSearch);
	 PagesBean getPage(PagesBean objPagesBean);
}
