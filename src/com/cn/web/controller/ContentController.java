package com.cn.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.entity.Content;
import com.cn.entity.Cost;
import com.cn.entity.User;
import com.cn.service.ContentService;
import com.cn.service.CostService;

@Controller
@Scope("prototype")
public class ContentController {
	@Resource(name = "costService")
	private CostService costService;
	@Resource(name = "contentService")
	private ContentService contentServcie;

	private Content content;
	private ModelAndView mav = new ModelAndView();
	private List<Content> contents;
	private List<Cost> costs;

	@RequestMapping("contents")
	public ModelAndView contents() {
		contents = this.contentServcie.contents();

		if (contents != null) {
			mav.setViewName("message");
			mav.addObject("contents", contents);

		}
		return mav;
	}
	@RequestMapping("addContent")
	public ModelAndView addContent(String userName, Content c, int costId,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		c.setUser(user);

		if (this.contentServcie.addContent(c, costId) > 0) {
			mav.setViewName("forward:succAdd.com");

		} else {
			mav.setViewName("addmessage");
		}
		return mav;

	}

	@RequestMapping("deleteContent")
	public ModelAndView deleteContent(int id, String userName, String method) {
		int result = this.contentServcie.deleteContentById(id);
		if (result > 0) {
			mav.setViewName("forward:succes.com");

		} else {
			mav.setViewName("redirect:failed.com");
		}
		return mav;
	}

	@RequestMapping("updateContent")
	public ModelAndView updateContent(String method,String userName, Content c, int costId,
			String ptime, HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = sdf.parse(ptime);
			User user = (User) request.getSession().getAttribute("user");
			c.setUser(user);
			c.setPublishtime(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (this.contentServcie.updateContent(c, costId) != null) {
			mav.setViewName("forward:succes.com");

		} else {
			mav.setViewName("updatemessage");
		}
		return mav;
	}

	@RequestMapping("preAddContent")
	public ModelAndView preAddContent() {
		costs = this.costService.costs();
		mav.setViewName("addmessage");
		mav.addObject("costs", costs);

		return mav;
	}

	@RequestMapping("preUpdateContent")
	public ModelAndView preUpdateContent(int id) {
		content = this.contentServcie.getContentById(id);
		costs = this.costService.costs();
		if (content != null) {
			mav.setViewName("updatemessage");
			mav.addObject("content", content);
			mav.addObject("costs", costs);
		} else {
			mav.setViewName("error");
		}

		return mav;
	}

	@RequestMapping(value = "succAdd")
	public String succAdd(String title, String userName) {

		return "main";
	}

	@RequestMapping(value = "succes")
	public String succes(int id, String userName, String method) {

		return "main";
	}

	@RequestMapping("failed")
	public String failed() {
		return "error";
	}

}
