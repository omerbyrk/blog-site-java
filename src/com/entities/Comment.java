package com.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name = "COMMENT")
public class Comment extends Member {

	private String opinion;
	private String email;
	private List<Answer> answerList = new ArrayList<>();
	private Blog blog;

	public Comment() {
	}

	@Column(name = "COMMENTOR_OPINION", columnDefinition="VARCHAR(255)")
	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	@Column(name = "COMMENTOR_EMAIL", columnDefinition= "VARCHAR(60)")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = javax.persistence.CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "COMMENT_ID")
	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BLOG_ID")
	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

}
