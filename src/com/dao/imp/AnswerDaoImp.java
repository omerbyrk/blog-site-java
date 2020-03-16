package com.dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AnswerDao;
import com.entities.Answer;

@Repository("answerDao")
@Transactional
public class AnswerDaoImp implements AnswerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Answer entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void delete(Answer entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Answer getBy(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Answer.class, id);
	}

	@Override
	public List<Answer> getList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createNamedQuery("getCategoryList", Answer.class).getResultList();
	}

	@Override
	public void update(Answer entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void saveOrUpdate(Answer entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

}
