package com.iter.spring.json;

public class Advertise {
	
	private long id;
	private String name;
	private String category;
	private String title;
	private String description;
	private String status;
	private String postID;
	
	private User user;

	public Advertise(long id, String name, String category, String title, String description, String status,
			String postID, User user) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.title = title;
		this.description = description;
		this.status = status;
		this.postID = postID;
		this.user = user;
	}

	public Advertise(String category, String title, String description,String status, String postID, String name, long id) {
		super();
		this.id=id;
		this.name=name;
		this.postID=postID;
		this.category = category;
		this.title = title;
		this.status=status;
		this.description = description;
	}
	
	public Advertise(long id, String name, String category, String title, String description) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.title = title;
		this.description = description;
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

	public String getPostID() {
		return postID;
	}

	public void setPostID(String postID) {
		this.postID = postID;
	}

	@Override
	public String toString() {
		return "Advertise [id=" + id + ", category=" + category + ", title=" + title + ", description=" + description
				+ "]";
	}

}