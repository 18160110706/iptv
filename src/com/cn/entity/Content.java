package com.cn.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_content", catalog = "iptv")
public class Content {
	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column
	private String title;
	@Column
	private String tcontent;
	@Column
	private Date publishtime;
	@Column
	private Date updatetime;
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	@OneToOne
	@JoinColumn(name="cost_id")
	private Cost cost;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Content( String title, String tcontent, Date publishtime,
			Date updatetime,User user,Cost cost) {
	
		this.title = title;
		this.tcontent = tcontent;
		this.publishtime = publishtime;
		this.updatetime = updatetime;
		this.user=user;
		this.cost=cost;

	}

		public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}

		public Content() {
		
	}

		public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTcontent() {
		return tcontent;
	}

	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}

	public Date getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	

}
