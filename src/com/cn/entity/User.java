package com.cn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user",catalog="iptv")
public class User {
	@Id
	@GeneratedValue
	@Column
	private int id;

	@Column
	private String userName;
	@Column
	private String passWord;

	public User(int id, String userName, String passWord, int isAdmin) {

		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.isAdmin = isAdmin;
	}

	public User() {

	}

	@Column
	private int isAdmin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

}
