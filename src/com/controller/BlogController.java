package com.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asistant.BlogAsistant;
import com.entities.Blog;
import com.service.BlogService;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@Autowired
	private BlogAsistant blogAsistant;

	@RequestMapping("/{blogId}")
	public ModelAndView showBlog(@PathVariable int blogId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Blog blog = null;
		
		try {
			
			blog = blogService.getBy(blogId);
			String cookieValue = String.valueOf(blog.getId());
			if (!blogAsistant.isCreatedCookie(request, cookieValue)) {
				System.out.println("-------------------------Yeni cookie olu�turuluyor.");
				blogAsistant.createCookie(new Cookie("DisplayedBlog-" + blogId, cookieValue), response);
				blogService.updateDisplay(blog);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(blogId + " id li blog �ekilirken bir hata olu�tu!");
		}
		return new ModelAndView("blog", "blog", blog);
	}

}
