package com.spring.FirstSpringDemo;

public class OrderBeans {

	private int price;
	private String name;
	public OrderBeans(int price, String name) {
		super();
		this.price = price;
		this.name = name;
	}
	public OrderBeans() {
		super();
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
