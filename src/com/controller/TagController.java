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
import com.service.TagService;

@Controller
@RequestMapping("/tag")
public class TagController {

	@Autowired
	private TagService tagService;

	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "/{tagName}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable String tagName, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") Integer currentPage) {

		long totalBlog = tagService.countBlog(tagName);
		return new ModelAndView("blogstore", "blogList", blogService.getListBy(currentPage, tagName))
				.addObject("totalBlog", totalBlog).addObject("title", tagName)
				.addObject("paginationUrl", request.getContextPath() + "/tag/" + tagName);
	}

}
