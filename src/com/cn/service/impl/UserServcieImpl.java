package com.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cn.dao.UserDao;
import com.cn.entity.User;
import com.cn.service.UserService;

@Service("userService")
@Transactional
public class UserServcieImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public User login(User u) {
		// TODO Auto-generated method stub
		return this.userDao.login(u);
	}

	@Override
	public List<User> users() {
		// TODO Auto-generated method stub
		return this.userDao.users();
	}

}
