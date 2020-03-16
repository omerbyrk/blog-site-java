package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exception")
@ControllerAdvice
public class ExceptionController {
	
	
	@RequestMapping("/404")
	public ModelAndView error404(){
		return new ModelAndView("/error/404");
	}
	
	@ExceptionHandler(Exception.class)
	@RequestMapping("/500")
	public ModelAndView error500(Exception ex, HttpServletRequest req) {
		return new ModelAndView("/error/500", "errorMessage", ex.getMessage()).addObject("errorUrl", req.getRequestURI());
	}
	
}
