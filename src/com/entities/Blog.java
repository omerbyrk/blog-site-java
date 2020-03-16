package com.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries(value = { @NamedQuery(name = "getBlogById", query = "from BLOG where BLOG_ID = :id"),
		@NamedQuery(name = "getBlogList", query = "from BLOG as b WHERE b.published = 1 ORDER BY date DESC"),
		@NamedQuery(name = "GetUnpublishedBlogList", query = "from BLOG as b WHERE b.published = 0 ORDER BY date DESC"),
		@NamedQuery(name = "CountBlogs", query = "Select count(*) from BLOG as b WHERE b.published = 1"),
		@NamedQuery(name = "SearchBlogs", query = "from BLOG where title LIKE :query or content LIKE :query"),
		@NamedQuery(name = "GetBlogsByCategoryName", query = "SELECT b from BLOG as b join b.categoryList as category where category.name=:CategoryName AND b.published = 1 ORDER BY b.date DESC"),
		@NamedQuery(name = "GetBlogsByTagName", query = "SELECT b from BLOG as b join b.tagList as tag where tag.name=:TagName AND b.published = 1 ORDER BY b.date DESC") })

@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity(name = "BLOG")
public class Blog {

	private int id;
	private String author;
	private String title;
	private String content;
	private String preview;
	private int display;
	private boolean published;
	private Date date;
	private List<Comment> commentList = new ArrayList<>();
	private List<Category> categoryList = new ArrayList<>();
	private List<Tag> tagList = new ArrayList<>();

	public Blog() {
	}

	public Blog(int id) {
		this.id = id;
	}

	public Blog(String author, String title, String content, String preview, List<Comment> commentList,
			List<Category> categoryList, List<Tag> tagList) {
		super();
		this.author = author;
		this.title = title;
		this.preview = content;
		this.commentList = commentList;
		this.categoryList = categoryList;
		this.tagList = tagList;
	}

	public Blog(String author, String title, String content, String preview) {
		super();
		this.author = author;
		this.title = title;
		this.content = content;
	}

	@Id
	@GeneratedValue
	@Column(name = "BLOG_ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "BLOG_AUTHOR", columnDefinition = "VARCHAR(50)")
	public String getAuthor() {
		if (this.author == null)
			return "Ömer Bayrak";

		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "BLOG_TITLE", columnDefinition = "VARCHAR(100)")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "BLOG_CONTENT", columnDefinition = "LONGTEXT")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "BLOG_PREVIEW", columnDefinition = "TEXT")
	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BLOG_RELEASE_DATE", columnDefinition = "VARCHAR(50)")
	public Date getDate() {
		if (date == null)
			return new Date();

		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Transient
	public String getFormatedDate() {
		return new SimpleDateFormat("dd MMMM yyyy").format(this.date);
	}

	@Column(name = "BLOG_DISPLAY", columnDefinition = "VARCHAR(5)")
	public int getDisplay() {
		return display;
	}

	public void setDisplay(int display) {
		this.display = display;
	}

	@Column(name = "BLOG_PUBLISHED", nullable = false)
	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.REMOVE)
	@JoinColumn(name = "BLOG_ID")
	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "BLOG_CATEGORY", joinColumns = @JoinColumn(name = "BLOG_ID"), inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade(CascadeType.SAVE_UPDATE)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "BLOG_TAG", joinColumns = @JoinColumn(name = "BLOG_ID"), inverseJoinColumns = @JoinColumn(name = "TAG_ID"))
	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", author=" + getAuthor() + ", title=" + title + ", content=" + content + ", preview="
				+ preview + ", date=" + getDate() + ", commentList=" + commentList + ", categoryList=" + categoryList
				+ ", tagList=" + tagList.size() + "]";
	}

}
