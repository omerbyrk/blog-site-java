package com.dao.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CategoryDao;
import com.entities.Blog;
import com.entities.Category;

@Transactional
@Repository("categoryDao")
public class CategoryDaoImp implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Category entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void delete(Category entity) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Category getBy(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Override
	public List<Category> getList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createNamedQuery("getCategoryList", Category.class).getResultList();
	}

	@Override
	public void update(Category entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void saveOrUpdate(Category entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public Category getBy(String name, boolean hasBlog, int currentPage) {
		// TODO Auto-generated method stub
		Category category = (Category) sessionFactory.getCurrentSession().createCriteria(Category.class)
				.add(Restrictions.eq("name", name)).uniqueResult();

		if (hasBlog) {
			category.setBlogList(sessionFactory.getCurrentSession().createCriteria(Blog.class).setCacheable(true)
					.createAlias("categoryList", "category").add(Restrictions.eq("category.id", category.getId()))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).setFirstResult((currentPage - 1) * 10)
					.setMaxResults(10).list());
		}

		return category;
	}

	@SuppressWarnings("deprecation")
	@Override
	public long countBlog(String categoryName) {
		// TODO Auto-generated method stub
		return (long) sessionFactory.getCurrentSession().createCriteria(Blog.class)
				.createAlias("categoryList", "category").add(Restrictions.eq("category.name", categoryName)).setCacheable(true)
				.setProjection(Projections.rowCount()).uniqueResult();
	}

}
