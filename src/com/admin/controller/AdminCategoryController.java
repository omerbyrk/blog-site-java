package com.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Category;
import com.operation.result.OperationResultHolder;
import com.service.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private OperationResultHolder operationResultHolder;
	
	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	public ModelAndView add(Category category, HttpServletRequest request) {
		try {
			category.setName(category.getName().toLowerCase().trim());
			categoryService.saveOrUpdate(category);
			System.out.println("Kategori kayýt edildi : " + category);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/panel/");
	}
	
	@RequestMapping(value = "/delete" , method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> add(@RequestParam Integer categoryId) {
		Map<String , Object> responseMap = new HashMap<>();
		try {
			System.out.println("Gelen kategori Id : " + categoryId);
			Category category = categoryService.getBy(categoryId);
			categoryService.delete(category);
			operationResultHolder.setSuccessResult("Ýlgili kategori silindi");
		}catch (Exception e) {
			e.printStackTrace();
			operationResultHolder.setDangerResult("Ýlgili kategori silinirken hata oluþtu" + e.getMessage());
		}
		
		responseMap.put("operationResult", operationResultHolder.getOperationResult());
		return responseMap;
	}
	
}
