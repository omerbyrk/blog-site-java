package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NamedQuery;

@NamedQuery(name = "getTagList" , query = "from TAG")

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity(name = "TAG")
public class Tag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	private String name;
	private List<Blog> blogList = new ArrayList<>();

	public Tag() { }

	public Tag(int id) { this.id = id; }
	
	public Tag(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Tag(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	@Column(name = "TAG_ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "TAG_NAME" , unique = true, columnDefinition = "VARCHAR(50)")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Transient
	public List<Blog> getBlogList() {
		return blogList;
	}

	public void setBlogList(List<Blog> blogList) {
		this.blogList = blogList;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + "]";
	}
	
}
