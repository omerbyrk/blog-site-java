package com.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Blog;
import com.entities.Category;
import com.entities.Tag;
import com.operation.result.OperationResultHolder;
import com.service.BlogService;
import com.service.TagService;

@Controller
@RequestMapping("/admin/panel")
@SessionAttributes("blog")
public class AdminPanelController {

	@Autowired
	private BlogService blogService;

	@Autowired
	private TagService tagService;

	@Autowired
	private OperationResultHolder operationResultHolder;

	@RequestMapping("/")
	public ModelAndView showPage(@RequestParam(required = false, defaultValue = "-1") Integer blogId) {
		Blog blog =  blogId == -1 ? new Blog() : blogService.getBy(blogId);
		return new ModelAndView("admin/adminpanel", "blog", blog).addObject("operationResult", operationResultHolder.getOperationResult()).addObject("category", new Category()).addObject("title","Admin Paneli");
	}

	@RequestMapping(value = "blog/add", method = RequestMethod.POST)
	public String add(@ModelAttribute Blog blog, @RequestParam("tags") String tagList, HttpServletRequest request) {
		System.out.println("Publish Test: " + blog.isPublished());
		try{
			blog.getTagList().clear();
			for (String tagName : tagList.split(",")) {
				tagName = tagName.trim().toLowerCase();
				if(!tagName.isEmpty())
					blog.getTagList().add(convertToTag(tagName.trim().toLowerCase()));
			}
			blogService.saveOrUpdate(blog);
			operationResultHolder.setSuccessResult("Blog baþarýyla kayýt edildi.");
		}catch(Exception e){
			e.printStackTrace();
			operationResultHolder.setDangerResult("Blog kayýt edilirken bir hata oluþtu. " + e.getMessage());
		}
		return "redirect:/admin/panel/";
	}
	
	@RequestMapping(value = "blog/delete", method = RequestMethod.GET)
	public String delete(@RequestParam Integer blogId, HttpServletRequest request) {
		try {
			
			Blog blog = blogService.getBy(blogId);
			blogService.delete(blog);
			operationResultHolder.setSuccessResult("Blog baþarýyla silindi.");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			operationResultHolder.setDangerResult("Blog kayýt silinirken bir hata oluþtu. " + e.getMessage());
		}
		return "redirect:/admin/panel/";
	}

	public Tag convertToTag(String tagName) {
		Tag tag = tagService.getBy(tagName);
		System.out.println("Db tag : " + tag);
		return tag != null ? tag : new Tag(tagName);

	}

}
