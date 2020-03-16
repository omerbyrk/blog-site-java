package com.dao.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TagDao;
import com.entities.Blog;
import com.entities.Tag;
import com.entities.TagView;

@Repository("tagDao")
@Transactional
public class TagDaoImp implements TagDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Tag entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void delete(Tag entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public Tag getBy(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Tag.class, id);
	}

	@Override
	public List<Tag> getList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createNamedQuery("getTagList",Tag.class).setCacheable(true).getResultList();
	}

	@Override
	public void update(Tag entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void saveOrUpdate(Tag entity) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Tag getBy(String name) {
		// TODO Auto-generated method stub
		return (Tag) sessionFactory.getCurrentSession().createCriteria(Tag.class).add(Restrictions.eq("name", name)).uniqueResult();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public Tag getBy(String name, boolean hasBlog, int currentPage) {
		System.out.println("name : " + name);
		Tag tag = (Tag) sessionFactory.getCurrentSession().createCriteria(Tag.class)
										   .add(Restrictions.eq("name", name))
										   .uniqueResult();

		if (hasBlog) {
			tag.setBlogList(sessionFactory.getCurrentSession().createCriteria(Blog.class)
					.createAlias("tagList", "tag").add(Restrictions.eq("tag.id", tag.getId()))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
					.setFirstResult((currentPage - 1) * 10)
					.setMaxResults(10)
					.list());
		}

		return tag;
	}

	@SuppressWarnings("deprecation")
	@Override
	public long countBlog(String tagName) {
		// TODO Auto-generated method stub
		return (long) sessionFactory.getCurrentSession().createCriteria(Blog.class)
									 .createAlias("tagList", "tag").add(Restrictions.eq("tag.name", tagName)).setCacheable(true)
									 .setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public List<TagView> getListView() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createNamedQuery("tagview", TagView.class).getResultList();
	}

}
