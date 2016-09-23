package io.github.lucasvenez.ormclass;

import java.util.Date;

import io.github.lucasvenez.ormclass.dao.OrderDAO;
import io.github.lucasvenez.ormclass.model.City;
import io.github.lucasvenez.ormclass.model.Country;
import io.github.lucasvenez.ormclass.model.Order;
import io.github.lucasvenez.ormclass.model.Person;
import io.github.lucasvenez.ormclass.model.State;

public class Main {

	public static void main(String[] args) {
		
		Country country = new Country("Brasil");
		State state = new State("São Paulo", country);
		City city = new City("Caraguatatuba", state);
		
		Person person = new Person();
		person.setFullname("Cleyton de Castro Mario");
		person.setCity(city);
		
		Order order = new Order();
		order.setPerson(person);
		
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.persist(order);
		
	}

}
