package com.cn.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.entity.User;
import com.cn.service.UserService;

@Controller
@Scope("prototype")
public class UserController {
	@Autowired
	private UserService userService;
	ModelAndView mav=new ModelAndView();
	@RequestMapping("login")
	public ModelAndView login(User user,HttpServletRequest request){
		HttpSession session=request.getSession();
		//hahahaha
		user=this.userService.login(user);
		if(user!=null){
			session.setAttribute("user", user);
			mav.setViewName("forward:succ.com");
			
		
		}else{
			mav.setViewName("redirect:fail.com");
		}
		return mav;
	}
	@RequestMapping("doLogin")
	public String doLogin(){
		return "login";
		
	}
	@RequestMapping("succ")
	public String succ(String userName){
		System.out.println("�ɹ���");
		return "main";
	}
	@RequestMapping("fail")
	public String fail(){
		return "login";
	}
}
