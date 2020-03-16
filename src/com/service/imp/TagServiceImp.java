package com.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TagDao;
import com.entities.Tag;
import com.entities.TagView;
import com.service.TagService;

@Service("tagService")
public class TagServiceImp implements TagService{
	
	@Autowired
	private TagDao tagDao;

	@Override
	public void save(Tag entity) {
		// TODO Auto-generated method stub
		tagDao.save(entity);
	}

	@Override
	public void delete(Tag entity) {
		// TODO Auto-generated method stub
		tagDao.delete(entity);
	}

	@Override
	public Tag getBy(int id) {
		// TODO Auto-generated method stub
		return tagDao.getBy(id);
	}

	@Override
	public List<Tag> getList() {
		// TODO Auto-generated method stub
		return tagDao.getList();
	}

	@Override
	public void update(Tag entity) {
		// TODO Auto-generated method stub
		tagDao.getList();
	}

	@Override
	public void saveOrUpdate(Tag entity) {
		// TODO Auto-generated method stub
		tagDao.saveOrUpdate(entity);
	}

	@Override
	public Tag getBy(String name) {
		// TODO Auto-generated method stub
		return tagDao.getBy(name);
	}

	@Override
	public Tag getBy(String name, boolean hasBlog, int currentPage) {
		// TODO Auto-generated method stub
		return tagDao.getBy(name, hasBlog, currentPage);
	}

	@Override
	public long countBlog(String tagName) {
		// TODO Auto-generated method stub
		return tagDao.countBlog(tagName);
	}

	@Override
	public List<TagView> getListView() {
		// TODO Auto-generated method stub
		return tagDao.getListView();
	}

}
