package com.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AnswerDao;
import com.entities.Answer;
import com.service.AnswerService;

@Service("answerService")
public class AnswerServiceImp implements AnswerService{
	
	@Autowired
	AnswerDao answerDao;

	@Override
	public void save(Answer entity) {
		// TODO Auto-generated method stub
		answerDao.save(entity);
	}

	@Override
	public void delete(Answer entity) {
		// TODO Auto-generated method stub
		answerDao.delete(entity);
	}

	@Override
	public Answer getBy(int id) {
		// TODO Auto-generated method stub
		return answerDao.getBy(id);
	}

	@Override
	public List<Answer> getList() {
		// TODO Auto-generated method stub
		return answerDao.getList();
	}

	@Override
	public void update(Answer entity) {
		// TODO Auto-generated method stub
		answerDao.update(entity);
	}

	@Override
	public void saveOrUpdate(Answer entity) {
		// TODO Auto-generated method stub
		answerDao.saveOrUpdate(entity);
	}

}
