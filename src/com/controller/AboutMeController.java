package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class AboutMeController {

	@RequestMapping("omer-byrk")
	public String show() {
		return "about";
	}
	
}
