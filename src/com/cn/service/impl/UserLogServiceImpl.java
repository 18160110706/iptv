package com.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.dao.UserLogDao;
import com.cn.entity.UserLog;
import com.cn.service.UserLogService;

@Service
@Transactional
public class UserLogServiceImpl implements UserLogService {
	@Autowired
	private UserLogDao userLogDao;

	@Override
	public int addUserLog(UserLog u) {
		// TODO Auto-generated method stub
		return this.userLogDao.addUserLog(u);
	}

}
