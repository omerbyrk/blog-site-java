package com.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.gadgets.RandomNumberBuilder;

@Entity(name = "MEMBER")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Member {

	private int id;
	private String name;
	private String photoName;
	private String tag;
	private boolean admin = false;
	private Date date;

	@Id
	@GeneratedValue
	@Column(name = "MEMBER_ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "MEMBER_NAME", columnDefinition= "VARCHAR(50)")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "MEMBER_PHOTO_NAME", columnDefinition= "VARCHAR(30)")
	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	@Column(name = "MEMBER_TAG", columnDefinition= "VARCHAR(30)")
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Column(name = "MEMBER_IS_ADMIN")
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MEMBER_DATE")
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
		return new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH).format(getDate());
	}
	
	public final void authorize() {
		// TODO Auto-generated method stub
		if (!this.isAdmin()) // admin deðilse.
		{
			this.setPhotoName("photo" + RandomNumberBuilder.build(4) + ".png");
			this.setTag("member");
			return;
		}

		this.setName("Ömer Bayrak");
		this.setPhotoName("profil.jpg");
		this.setTag("admin");
	}

}
