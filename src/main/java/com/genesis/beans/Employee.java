package com.genesis.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	
	
	@Id
	private int eno;
	private String ename;
	private int esal;
	private Address add;
	@OneToOne(fetch = FetchType.LAZY)
	private Laptop lap;
	@OneToMany(mappedBy = "employee" , fetch = FetchType.LAZY)
	private List<Vehicle> vehicle;
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Project> projects;
	
	
	public Employee(int eno, String ename, int esal, Address add, Laptop lap, List<Vehicle> vehicle, List<Project> projects) {
		this.eno = eno;
		this.ename = ename;
		this.esal = esal;
		this.add = add;
		this.lap = lap;
		this.vehicle = vehicle;
		this.projects = projects;
	}
	public Employee(int eno, String ename, int esal, Address add, Laptop lap, List<Vehicle> vehicle) {
		this.eno = eno;
		this.ename = ename;
		this.esal = esal;
		this.add = add;
		this.lap = lap;
		this.vehicle = vehicle;
	}
	public Employee(int eno, String ename, int esal, Address add, Laptop lap) {
		this.eno = eno;
		this.ename = ename;
		this.esal = esal;
		this.add = add;
		this.lap = lap;
	}
	public Employee(int eno, String ename, int esal, Address add) {
		this.eno = eno;
		this.ename = ename;
		this.esal = esal;
		this.add = add;
	}
	
	public Employee(int eno) {
		this.eno = eno;
	}
	public Employee() {
		super();
	}
	
	
	public Laptop getLap() {
		return lap;
	}
	public void setLap(Laptop lap) {
		this.lap = lap;
	}
	public Address getAdd() {
		return add;
	}
	
	public void setAdd(Address add) {
		this.add = add;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEsal() {
		return esal;
	}
	public void setEsal(int esal) {
		this.esal = esal;
	}
	public List<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	@Override
	public String toString() {		
		String s= "Employee [eno=" + eno + ", ename=" + ename + ", esal=" + esal + ", add=" + add + ", laptop=" + 
				(lap!=null?lap.getCode():null)+ ", vehicle(s)=" ;
		for(Vehicle e:vehicle) {
			if(vehicle.indexOf(e)!=0)
				s+=",";
			s+=e.getRegno();
		}
		s+=", project id(s)=";
		for(Project e:projects) {
			if(projects.indexOf(e)!=0)
				s+=",";
			s+=e.getCode();
		}
		s+= "]";
		return s;
	}
	
	
	
}
