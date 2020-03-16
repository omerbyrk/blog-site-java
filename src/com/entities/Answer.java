package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "answer")
public class Answer extends Member {

	private String answer;

	@Column(name = "ANSWERER_OPINION")
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
