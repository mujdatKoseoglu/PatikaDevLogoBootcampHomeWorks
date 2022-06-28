package com.logo.model;

import com.logo.model.enums.FirmType;

import java.util.List;

public class Customer {

	private String name;
	private int age;
	private List<Order> orderList;
	private Boolean state;

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Customer(String name, int age, List<Order> orderList) {
		super();
		this.name = name;
		this.age = age;
		this.orderList = orderList;
		this.state=false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

}
