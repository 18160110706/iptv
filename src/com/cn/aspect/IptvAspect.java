package com.cn.aspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.entity.UserLog;
import com.cn.service.UserLogService;
//张鑫编写
@Aspect
@Component
public class IptvAspect {
	@Autowired
	private UserLogService userLogService;
	
	@After("execution(* com.cn.web.controller.UserController.succ(..))")
	public void loginLog(JoinPoint jp){
		Object[] obj=jp.getArgs();
		String userName=obj[0].toString();
		Date d=new Date();
		UserLog u=new UserLog();
		u.setUserName(userName);
		u.setTime(d);
		u.setDoWhat("登录");
		System.out.println(u);
		this.userLogService.addUserLog(u);
	}
	@After("execution(* com.cn.web.controller.ContentController.succAdd(..))")
	public void addContent(JoinPoint jp){
	Object[] obj=jp.getArgs();
		String title=obj[0].toString();
		String userName=obj[1].toString();
		Date d=new Date();
		UserLog u=new UserLog();
		u.setUserName(userName);
		u.setTime(d);
		u.setDoWhat("添加了"+title);
		System.out.println("添加成功");
		this.userLogService.addUserLog(u);
	}
	@After("execution(* com.cn.web.controller.ContentController.succes(..))")
	public void doContent(JoinPoint jp){
		Object[] obj=jp.getArgs();
		String id=obj[0].toString();
		String userName=obj[1].toString();
		System.out.println(userName);
		String method=obj[2].toString();
		Date d=new Date();
		UserLog u=new UserLog();
		u.setUserName(userName);
		u.setTime(d);
		u.setDoWhat(method+"contentID是"+id);
		this.userLogService.addUserLog(u);
	}
}
