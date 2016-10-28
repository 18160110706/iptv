package com.cn.dao;

import java.util.List;

import com.cn.entity.User;

public interface UserDao {
	public User login(User u);
	public List<User> users();

}
