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

@NamedQuery(name = "getCategoryList", query = "from CATEGORY ORDER BY order ASC", cacheable = true)

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity(name = "CATEGORY")
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	private String name;
	private int order;
	private List<Blog> blogList = new ArrayList<>();

	public Category() {
	}

	public Category(int id) {
		this.id = id;
	}
	
	/**
	 * Spring formdan , id ' e atayaca��m�z integer de�er , varsay�lan olarak 'name' de�i�kenine atand��� i�in
	 * gelen de�er sadece say� ise , hatas�z id de�i�kenine aktar�l�yor. E�er de�ilse , hata veriyor ve name de�i�kenine aktar�l�yor.
	 * */
	public Category(String name) {
		try {
			setId(Integer.valueOf(name));
		} catch (Exception e) {
			this.name = name;
			e.printStackTrace();
		};
	}

	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID", unique = true)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "CATEGORY_NAME", unique = true, columnDefinition = "VARCHAR(30)")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "MENU_ORDER")
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int order) {
		this.order = order;
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
		return "Category [id=" + id + ", name=" + name + "]";
	}

}
