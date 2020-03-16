package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.service.BlogService;

@Controller
public class SearchController {
	
	@Autowired
	BlogService blogService;
	
	@RequestMapping(value = {"search"})
	public ModelAndView indexBy(HttpServletRequest request , @RequestParam String query) throws Exception {
		return new ModelAndView("blogstore", "blogList" , blogService.searchBy(query))
					  .addObject("title", "Arama Sonucu");
	}

}
