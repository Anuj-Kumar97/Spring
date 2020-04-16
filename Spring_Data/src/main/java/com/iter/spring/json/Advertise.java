package com.iter.spring.json;

import java.time.LocalDateTime;

public class Advertise {
	
	private long id;
	private String name;
	private String category;
	private String title;
	private String description;
	private String status;
	private String postID;
	private LocalDateTime ldt;
	
	private User user;

	public Advertise(long id, String name, String category, String title, String description, String status,
			String postID, LocalDateTime ldt) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.title = title;
		this.description = description;
		this.status = status;
		this.postID = postID;
		this.ldt=ldt;
	}

	public Advertise(String category, String title, String description,String status, String postID, String name, long id, LocalDateTime ldt) {
		super();
		this.id=id;
		this.name=name;
		this.postID=postID;
		this.category = category;
		this.title = title;
		this.status=status;
		this.description = description;
		this.ldt=ldt;
	}
	
	public Advertise(long id, String name, String category, String title, String description, LocalDateTime ldt) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.title = title;
		this.description = description;
		this.ldt=ldt;
	}

	public Advertise() {}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public LocalDateTime getLdt() {
		return ldt;
	}

	public void setLdt(LocalDateTime ldt) {
		this.ldt = ldt;
	}
	
	public String getPostID() {
		return postID;
	}

	public void setPostID(String postID) {
		this.postID = postID;
	}

	@Override
	public String toString() {
		return "Advertise [id=" + id + ", name=" + name + ", category=" + category + ", title=" + title
				+ ", description=" + description + ", status=" + status + ", postID=" + postID + ", ldt=" + ldt
				+ ", user=" + user + "]";
	}

}
