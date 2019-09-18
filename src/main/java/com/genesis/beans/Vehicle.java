package com.genesis.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {

	@Id
	private String regno;
	private String brand;
	private String model;
	private float price;
	@ManyToOne(fetch = FetchType.LAZY)
	private Employee employee;
	
	public Vehicle() {
	}

	public Vehicle(String regno) {
		this.regno = regno;
	}

	public Vehicle(String regno, String brand, String model, float price) {
		this.regno = regno;
		this.brand = brand;
		this.model = model;
		this.price = price;
	}

	public Vehicle(String regno, String brand, String model, float price, Employee employee) {
		this.regno = regno;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.employee = employee;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Vehicle [regno=" + regno + ", brand=" + brand + ", model=" + model + ", price=" + price +", employee="+employee.getEno()+ "]";
	}
	
	
	
}
