package com.spring.FirstSpringDemo;

public class AccountBean {
	private int id;
	private String name;
	public AccountBean() {
		super();
		System.out.println("Inside Constructor");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AccountBean [id=" + id + ", name=" + name + "]";
	}
	
	

}
