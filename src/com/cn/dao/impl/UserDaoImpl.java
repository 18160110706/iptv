package com.cn.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;

import com.cn.dao.UserDao;
import com.cn.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private JpaTemplate jpaTemplate;

	@Override
	public User login(User u) {
		System.out.println(u.getUserName()+u.getPassWord());
		List<User> users = this.jpaTemplate.find(
				"from User u where u.userName=? and u.passWord=?",
				new Object[] { u.getUserName(), u.getPassWord() });
		System.out.println(users);
		if(users!=null&&users.size()>0){
			System.out.println(users.get(0)
					
			);
			return users.get(0);
		}
		return null;
	}

	@Override
	public List<User> users() {
		// TODO Auto-generated method stub
		return this.jpaTemplate.find("from User");
	}

}
