package com.genesis.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	private int code;
	private String title;
	private String company;
	@ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
	private List<Employee> employees;
	
	
	
	public Project() {
	}
	public Project(int code) {
		this.code = code;
	}
	public Project(int code, String title, String company) {
		this.code = code;
		this.title = title;
		this.company = company;
	}
	
	
	public Project(int code, String title, String company, List<Employee> employees) {
		this.code = code;
		this.title = title;
		this.company = company;
		this.employees = employees;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		String s= "Project [code=" + code + ", title=" + title + ", company=" + company+", employees=";
		for(Employee e:employees) {
			if(employees.indexOf(e)!=0)
				s+=",";
			s+=e.getEno();
		}
		s+= "]";
		return s;
	}
	
	
	
}
