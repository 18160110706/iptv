package com.cn.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;

import com.cn.dao.CostDao;
import com.cn.entity.Cost;
@Repository
public class CostDaoImpl implements CostDao {
	@Autowired
	private JpaTemplate jpaTemplate;
	@Override
	public List<Cost> costs() {
		// TODO Auto-generated method stub
		return this.jpaTemplate.find("from Cost");
	}

}
