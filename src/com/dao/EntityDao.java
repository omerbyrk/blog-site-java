package com.dao;

import java.util.List;

public interface EntityDao<T> {
	
	public void save(T entity);
	
	public void delete(T entity);

	public T getBy(int id);
	
	public List<T> getList();
	
	public void update(T entity);
	
	public void saveOrUpdate(T entity);
	
}
