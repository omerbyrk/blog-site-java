package com.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CommentDao;
import com.entities.Comment;

@Repository("commentDao")
@Transactional
public class CommentDaoImp implements CommentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Comment entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void delete(Comment entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Comment getBy(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Comment.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from comment").getResultList();
	}

	@Override
	public void update(Comment entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void saveOrUpdate(Comment entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

}
