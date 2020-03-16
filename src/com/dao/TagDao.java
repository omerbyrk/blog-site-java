package com.dao;

import java.util.List;

import com.entities.Tag;
import com.entities.TagView;

public interface TagDao extends EntityDao<Tag> {

	public Tag getBy(String name);
	
	public Tag getBy(String name , boolean hasBlog , int currentPage);
	
	public long countBlog(String tagName);
	
	public List<TagView> getListView();
	
}
