package com.dao;

import java.util.List;

import com.entities.Blog;

public interface BlogDao extends EntityDao<Blog>{
	
	public List<Blog> getListBy(int currentPage);
	
	public long count();
	
	public void updateDisplay(Blog blog);
	
	public List<Blog> getListBy(int currentPage, String tagName);
	
	public List<Blog> getListBy(String categoryName, int currentPage);
	
	public List<Blog> searchBy(String queryText);
	
	public List<Blog> getUnpublishedBlogList();
	
}
