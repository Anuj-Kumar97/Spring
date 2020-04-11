package com.spring.FirstSpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmpDeptApp {
	
	@Autowired
	@Qualifier("department")
	DepartmentBean department1 ;
	
	@Autowired
	EmployeeBean employee;
	
	public EmpDeptApp() {
		super();
		 
	}
	
	public EmpDeptApp(DepartmentBean department, EmployeeBean employee) {
		super();
		this.department1 = department;
		this.employee = employee;
	}

	public DepartmentBean getDepartment() {
		return department1;
	}
	public void setDepartment(DepartmentBean department) {
		this.department1 = department;
	}
	public EmployeeBean getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeBean employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "EmpDeptApp [department=" + department1 + ", employee=" + employee + "]";
	}

}
