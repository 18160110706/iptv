package com.cn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="user_log",catalog="iptv")
public class UserLog {
	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column(name="userName")
	private String userName;
	@Column(name="time")
	private Date time;
	@Column(name="doWhat")
	private String doWhat;
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getDoWhat() {
		return doWhat;
	}
	public void setDoWhat(String doWhat) {
		this.doWhat = doWhat;
	}
	public UserLog() {
		
	}

}
