package com.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cn.dao.ContentDao;
import com.cn.entity.Content;
import com.cn.service.ContentService;

@Service("contentService")
@Transactional
public class ContentServiceImpl implements ContentService {
	@Autowired
	private ContentDao contentDao;

	@Override
	public int addContent(Content c,int costId) {
		// TODO Auto-generated method stub
		return this.contentDao.addContent(c, costId);
	}

	@Override
	public List<Content> contents() {
		// TODO Auto-generated method stub
		return this.contentDao.contents();
	}

	@Override
	
	public int deleteContentById(int id) {
		// TODO Auto-generated method stub
		return this.contentDao.deleteContentById(id);
	}

	@Override
	public Content getContentById(int id) {
		// TODO Auto-generated method stub
		return this.contentDao.getContentById(id);
	}

	@Override
	public Content updateContent(Content c,int costId) {
		// TODO Auto-generated method stub
		return this.contentDao.updateContent(c,costId);

	}

}
