package com.cn.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;

import com.cn.dao.UserLogDao;
import com.cn.entity.UserLog;

@Repository
public class UserLogDaoImpl implements UserLogDao {
	@Autowired
	private JpaTemplate jpaTemplate;

	@Override
	public int addUserLog(UserLog u) {

		try {
			this.jpaTemplate.persist(u);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		
	}

}
