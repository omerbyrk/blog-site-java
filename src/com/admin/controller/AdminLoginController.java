package com.admin.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.operation.result.OperationResultHolder;

@Controller
@RequestMapping("login")
public class AdminLoginController {
	
	@Autowired
	OperationResultHolder operationResultHolder;
	
	@RequestMapping("/form")
	public ModelAndView login() {
		
		return new ModelAndView("admin/login");
	}
	
	@RequestMapping(value = "/process" , method = RequestMethod.POST)
	public ModelAndView login(String username , String password, HttpServletRequest request) {
		if(username.equals("Qmer06") && password.equals("054627736zx")) {
			request.getSession().setAttribute("admin", "admin");
			return new ModelAndView("redirect:/index");
		}
		
		return new ModelAndView("redirect:/login/form");
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request , HttpServletResponse response) throws Exception {
		
		try {
			Cookie loginCookie = null;
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("JSESSIONID")) {
					request.getSession().removeAttribute("admin");
					loginCookie = cookie;
					break;
				}
			}
			
			loginCookie.setValue("");
			loginCookie.setPath("/");
			loginCookie.setMaxAge(0);
			response.addCookie(loginCookie);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new  Exception("Zaten giriþ yapýlmamýþ.!");
		}
		
		return "redirect:/index";
	}

}
