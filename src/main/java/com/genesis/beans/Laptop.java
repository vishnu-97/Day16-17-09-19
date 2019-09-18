package com.genesis.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Laptop {
	@Id
	private int code;
	private String name;
	private float price;
	@OneToOne(mappedBy = "lap",fetch = FetchType.LAZY)
	private Employee emp;
	
	public Laptop() {
	}
	public Laptop(int code, String name, float price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}
	
	public Laptop(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Laptop [code=" + code + ", name=" + name + ", price=" + price  +", employee="+(emp!=null?emp.getEno():null)+ "]";
	}

	
}
