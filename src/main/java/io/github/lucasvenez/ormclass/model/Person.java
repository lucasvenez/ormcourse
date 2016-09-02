package io.github.lucasvenez.ormclass.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {

	private Integer idPerson;
	
	private String fullname;
	
	private Date birthdate;
	
	private City city;
	
	private final List<Order> orders = new ArrayList<Order>();

	public Integer getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Order> getOrders() {
		return orders;
	}
	
	public void addOrder(Order order) {
		this.orders.add(order);
	}
}
