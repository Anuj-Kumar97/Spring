package com.spring.FirstSpringDemo;

import org.springframework.beans.factory.BeanNameAware;

public class Student implements BeanNameAware {

	private int id;
	private String name;
	private int marks;
	
	public Student()
	{
		super();
		System.out.println("Inside Constructor");
	}
	public static void init()
	{
		System.out.println("Initialized");
	}
	public static void destroy()
	{
		System.out.println("Destroyed");
	}

	public Student(int id, String name, int marks) {
		super();
		System.out.println("Constructor argument called");
		this.id = id;
		this.name = name;
		this.marks = marks;
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

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}
	public void setBeanName(String name) {
		
		System.out.println("Inside BeanAware Inteface");
		this.name=name;
		
	}
	
}
