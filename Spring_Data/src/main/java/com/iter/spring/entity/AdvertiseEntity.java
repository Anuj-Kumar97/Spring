package com.iter.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Advertisements")
public class AdvertiseEntity {
	
	@GeneratedValue
	@Id
	@Column(name="Adv_ID")
	private long id;
	
	@Column(name="Category")
	private String category;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="Post_ID")
	private String postID;
	
	@ManyToOne
	private UserEntity userEntity;
	
	public AdvertiseEntity(long id, String name, String category, String title, String description, String status,
			String postID, UserEntity userEntity) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.title = title;
		this.description = description;
		this.status = status;
		this.postID = postID;
		this.userEntity = userEntity;
	}

	public AdvertiseEntity(String category, String title, String description) {
		super();
		this.category = category;
		this.title = title;
		this.description = description;
	}
	
	public AdvertiseEntity() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPostID() {
		return postID;
	}

	public void setPostID(String postID) {
		this.postID = postID;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	@Override
	public String toString() {
		return "Advertise [id=" + id + ", category=" + category + ", title=" + title + ", description=" + description
				+ "]";
	}

}