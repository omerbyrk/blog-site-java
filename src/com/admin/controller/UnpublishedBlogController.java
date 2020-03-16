package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.BlogService;

@Controller
@RequestMapping("/admin")
public class UnpublishedBlogController {
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping("blogs/unpublished")
	public ModelAndView show() {
		return new ModelAndView("blogstore", "blogList", blogService.getUnpublishedBlogList());
	}
	
}
