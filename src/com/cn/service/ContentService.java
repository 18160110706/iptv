package com.cn.service;

import java.util.List;

import com.cn.entity.Content;

public interface ContentService {
	public List<Content>  contents();
	public int addContent(Content c,int costId);
	public int deleteContentById(int id);
	public Content updateContent(Content c,int costId);
	public Content getContentById(int id);

}
