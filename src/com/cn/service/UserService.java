package com.cn.service;

import java.util.List;

import com.cn.entity.User;

public interface UserService {
	
	public User login(User u);
	public List<User> users();

}
