package com.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CommentDao;
import com.entities.Comment;
import com.service.CommentService;

@Service("commentService")
public class CommentServiceImp implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Override
	public void save(Comment entity) {
		// TODO Auto-generated method stub
		commentDao.save(entity);
	}

	@Override
	public void delete(Comment entity) {
		// TODO Auto-generated method stub
		commentDao.delete(entity);
	}

	@Override
	public Comment getBy(int id) {
		// TODO Auto-generated method stub
		return commentDao.getBy(id);
	}

	@Override
	public List<Comment> getList() {
		// TODO Auto-generated method stub
		return commentDao.getList();
	}

	@Override
	public void update(Comment entity) {
		// TODO Auto-generated method stub
		commentDao.update(entity);
	}

	@Override
	public void saveOrUpdate(Comment entity) {
		// TODO Auto-generated method stub
		commentDao.saveOrUpdate(entity);
	}

}
