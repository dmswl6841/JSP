package com.jay.prj;

public class EmpVO {
	
	private String employeeId;
	private String firstName;
	private String salary;
	
	public EmpVO(String employeeId, String firstName, String salary) {	//인수가 있는 생성자를 만들면 인수가 없는 생성자도 만들어야한다
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.salary = salary;
	}
	
	public EmpVO() {	//기본생성자 (인수가 없는 생성자)
		super();
	}

	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	
}
