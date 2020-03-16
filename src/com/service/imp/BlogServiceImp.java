package com.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BlogDao;
import com.entities.Blog;
import com.service.BlogService;

@Service("blogService")
public class BlogServiceImp implements BlogService {

	@Autowired
	private BlogDao blogDao;

	@Override
	public void save(Blog entity) {
		// TODO Auto-generated method stub
		blogDao.save(entity);
	}

	@Override
	public void delete(Blog entity) {
		// TODO Auto-generated method stub
		blogDao.delete(entity);
	}

	@Override
	public Blog getBy(int id) {
		// TODO Auto-generated method stub
		return blogDao.getBy(id);
	}

	@Override
	public List<Blog> getList() {
		// TODO Auto-generated method stub
		return blogDao.getList();
	}

	@Override
	public void update(Blog entity) {
		// TODO Auto-generated method stub
		blogDao.update(entity);
	}

	@Override
	public void saveOrUpdate(Blog entity) {
		// TODO Auto-generated method stub
		blogDao.saveOrUpdate(entity);
	}

	@Override
	public List<Blog> getListBy(int currentPage) {
		// TODO Auto-generated method stub
		return blogDao.getListBy(currentPage);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return blogDao.count();
	}

	@Override
	public void updateDisplay(Blog blog) {
		// TODO Auto-generated method stub
		blogDao.updateDisplay(blog);
	}

	@Override
	public List<Blog> getListBy(int currentPage, String tagName) {
		// TODO Auto-generated method stub
		return blogDao.getListBy(currentPage, tagName);
	}

	@Override
	public List<Blog> getListBy(String categoryName, int currentPage) {
		// TODO Auto-generated method stub
		return blogDao.getListBy(categoryName, currentPage);
	}

	@Override
	public List<Blog> searchBy(String queryText) {
		// TODO Auto-generated method stub
		return blogDao.searchBy(queryText);
	}

	@Override
	public List<Blog> getUnpublishedBlogList() {
		// TODO Auto-generated method stub
		return blogDao.getUnpublishedBlogList();
	}
	
}
