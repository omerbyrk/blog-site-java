package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.NamedQuery;

@NamedQuery(name = "tagview", query = "from tagview", cacheable = true)

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity(name = "tagview")
@Immutable
public class TagView {

	private int id;
	private String name;
	private int totalBlog;

	@GeneratedValue
	@Id
	@Column(name = "TAG_ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "TAG_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "TOTAL_BLOG")
	public int getTotalBlog() {
		return totalBlog;
	}

	public void setTotalBlog(int totalBlog) {
		this.totalBlog = totalBlog;
	}

}
