package com.dao.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BlogDao;
import com.entities.Blog;

@SuppressWarnings({ "deprecation", "unchecked" })
@Repository("blogDao")
@Transactional
public class BlogDaoImp implements BlogDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Blog entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void delete(Blog entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Blog getBy(int id) {
		// TODO Auto-generated method stub
		Blog blog = (Blog) sessionFactory.getCurrentSession().get(Blog.class, id);
		return blog;
	}

	@Override
	public List<Blog> getList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createNamedQuery("getBlogList", Blog.class)
				.getResultList();
	}

	@Override
	public void update(Blog entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void saveOrUpdate(Blog entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public List<Blog> getListBy(int currentPage) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createNamedQuery("getBlogList")
				.setFirstResult((currentPage - 1) * 5).setMaxResults(5).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return (Long) sessionFactory.getCurrentSession().createNamedQuery("CountBlogs").setCacheable(true).getSingleResult();
	}

	@Override
	public void updateDisplay(Blog blog) {
		sessionFactory.getCurrentSession().createQuery("update BLOG set BLOG_DISPLAY=:display where BLOG_ID=:id")
				.setParameter("display", blog.getDisplay() + 1).setParameter("id", blog.getId()).executeUpdate();
	}

	@Override
	public List<Blog> getListBy(int currentPage, String tagName) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createNamedQuery("GetBlogsByTagName", Blog.class).setParameter("TagName", tagName)
				.setFirstResult((currentPage - 1) * 5).setMaxResults(5).getResultList();
	}

	@Override
	public List<Blog> getListBy(String categoryName, int currentPage) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createNamedQuery("GetBlogsByCategoryName", Blog.class).setParameter("CategoryName", categoryName)
				.setFirstResult((currentPage - 1) * 5).setMaxResults(5).getResultList();
	}

	@Override
	public List<Blog> searchBy(String queryText) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createNamedQuery("SearchBlogs",Blog.class).setParameter("query", "%"+queryText+"%").getResultList();
	}

	@Override
	public List<Blog> getUnpublishedBlogList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createNamedQuery("GetUnpublishedBlogList",Blog.class).getResultList();
	}

}
