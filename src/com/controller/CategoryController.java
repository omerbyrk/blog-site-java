package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.service.BlogService;
import com.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/{categoryName}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable String categoryName, HttpServletRequest request, @RequestParam(required = false, defaultValue = "1") Integer currentPage) {

		long totalBlog = categoryService.countBlog(categoryName);
		return new ModelAndView("blogstore", "blogList", blogService.getListBy(categoryName, currentPage))
							   .addObject("totalBlog", totalBlog)
							   .addObject("title", categoryName)
							   .addObject("paginationUrl", request.getContextPath() +"/category/" + categoryName);
	}

}
