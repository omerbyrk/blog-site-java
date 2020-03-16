package com.asistant;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class BlogAsistant {
	
	public boolean isCreatedCookie(HttpServletRequest request , String cookieValue) {
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null ) {
			for (Cookie cookie : cookies) {
				if(cookieValue.equals(cookie.getValue()))
					return true;
			}
		}
		return false;
	}
	
	public void createCookie(Cookie cookie , HttpServletResponse response) {
		cookie.setMaxAge((365*24*60*60));
		cookie.setPath("/");
		response.addCookie(cookie);
	}

}
