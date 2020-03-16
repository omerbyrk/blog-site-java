package com.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CategoryDao;
import com.entities.Category;
import com.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImp implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public void save(Category entity) {
		// TODO Auto-generated method stub
		categoryDao.save(entity);
	}

	@Override
	public void delete(Category entity) {
		// TODO Auto-generated method stub
		categoryDao.delete(entity);
	}

	@Override
	public Category getBy(int id) {
		// TODO Auto-generated method stub
		return categoryDao.getBy(id);
	}

	@Override
	public List<Category> getList() {
		// TODO Auto-generated method stub
		return categoryDao.getList();
	}

	@Override
	public void update(Category entity) {
		// TODO Auto-generated method stub
		categoryDao.update(entity);
	}

	@Override
	public void saveOrUpdate(Category entity) {
		// TODO Auto-generated method stub
		categoryDao.saveOrUpdate(entity);
	}

	@Override
	public Category getBy(String name, boolean hasBlog , int currentPage) {
		// TODO Auto-generated method stub
		return categoryDao.getBy(name, hasBlog , currentPage);
	}

	@Override
	public long countBlog(String categoryName) {
		// TODO Auto-generated method stub
		return categoryDao.countBlog(categoryName);
	}

}
