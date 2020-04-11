package com.spring.SpringRestDemo;

public class Advertise {
	
	private String title;
	private String name;
	private String category;
	private String description;
	private String status;
	private String postId;
	
	public Advertise() {
		super();
		this.postId="";
		this.status="closed";
	}

	public Advertise(String title, String name, String category, String description, String status, String postId) {
		super();
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.status = status;
		this.postId = postId;
	}
	
	public Advertise(String title, String name, String category,String description)
	{
		super();
		this.title=title;
		this.name=name;
		this.category=category;
		this.description=description;
		this.postId="";
		this.status="closed";
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(getClass()!=obj.getClass())
			return false;
		Advertise adv=(Advertise) obj;
		if(name==null)
		{
			if(adv.name!=null)
				return false;
		}
		else if(!name.equals(adv.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Advertise [title=" + title + ", name=" + name + ", category=" + category + ", description="
				+ description + ", status=" + status + ", postId=" + postId + "]";
	}

}
