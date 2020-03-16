package com.dao;

import com.entities.Category;

public interface CategoryDao extends EntityDao<Category> {
	
	public Category getBy(String name , boolean hasBlog , int currentPage);
	
	public long countBlog(String categoryName);
	

}
