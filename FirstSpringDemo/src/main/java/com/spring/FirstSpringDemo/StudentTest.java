package com.spring.FirstSpringDemo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("StudentSpring.xml");
		Student s=(Student)ctx.getBean("student");
		System.out.println(s.toString());
		ctx.registerShutdownHook();
	}

}
