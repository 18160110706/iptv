package com.cn.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cn.dao.ContentDao;
import com.cn.entity.Content;
import com.cn.entity.Cost;

@Repository
public class ContentDaoImpl implements ContentDao {
	@Autowired
	private JpaTemplate jpaTemplate;

	public int addContent(Content c,int costId) {
		
		try {
			Cost cost=(Cost) this.jpaTemplate.find("from Cost c where c.id="+costId).get(0);
			c.setCost(cost);
			c.setPublishtime(new Date());
			
			this.jpaTemplate.persist(c);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}

	}


	@Override
	public List<Content> contents() {
		List<Content> contents = this.jpaTemplate.find("from Content");

		return contents;
	}

	public int deleteContentById(int id) {
		try {
			Object obj = this.jpaTemplate.find(Content.class, id);
			this.jpaTemplate.remove(obj);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return 0;
		}

	}

	@Override
	public Content getContentById(int id) {
		// TODO Auto-generated method stub
		return this.jpaTemplate.find(Content.class, id);
	}

	@Override
	public Content updateContent(Content c,int costId) {
		Cost cost=(Cost) this.jpaTemplate.find("from Cost c where c.id="+costId).get(0);
		c.setCost(cost);
		c.setUpdatetime(new Date());
		return this.jpaTemplate.merge(c);
	}

}
