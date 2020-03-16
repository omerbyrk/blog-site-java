package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.service.BlogService;

@Controller
public class IndexController {
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value = {"/" , "/index"})
	public ModelAndView indexBy(HttpServletRequest request , @RequestParam(required = false, defaultValue = "1") Integer currentPage) throws Exception {
		return new ModelAndView("blogstore", "blogList" , blogService.getListBy(currentPage))
					  .addObject("title", "Ana Sayfa")
					  .addObject("totalBlog", blogService.count())
					  .addObject("paginationUrl", request.getContextPath() + "/index");
	}
}
