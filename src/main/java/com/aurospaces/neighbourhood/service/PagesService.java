package com.aurospaces.neighbourhood.service;

import java.util.List;

import com.aurospaces.neighbourhood.bean.PagesBean;

public interface PagesService {
   boolean insertPages(PagesBean objPagesBean);
   List<PagesBean> getServices(PagesBean objPagesBean,	String likeSearch);
   public PagesBean getPage(PagesBean objPagesBean,String likeSearch);
}
