package com.spring.FirstSpringDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpDeptAppMain {
	
		public static void main(String[] args) 
		{
			ApplicationContext ctx=new ClassPathXmlApplicationContext("EmployeeDepartmentBean.xml");
			EmployeeBean e=(EmployeeBean)ctx.getBean("employee");
			System.out.println(e.getName());
		}

	}
