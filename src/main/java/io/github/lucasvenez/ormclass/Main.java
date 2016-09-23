package io.github.lucasvenez.ormclass;

import java.util.Date;

import io.github.lucasvenez.ormclass.dao.OrderDAO;
import io.github.lucasvenez.ormclass.model.Category;
import io.github.lucasvenez.ormclass.model.City;
import io.github.lucasvenez.ormclass.model.Country;
import io.github.lucasvenez.ormclass.model.Order;
import io.github.lucasvenez.ormclass.model.OrderItem;
import io.github.lucasvenez.ormclass.model.Person;
import io.github.lucasvenez.ormclass.model.Product;
import io.github.lucasvenez.ormclass.model.State;

public class Main {

	public static void main(String[] args) {
		
		Person person = new Person();
		person.setBirthdate(new Date());
		person.setCity(new City("Caragua", new State("SP", new Country("Brasil"))));
		
		Category refrigerante = new Category("Refrigerante");
		
		Product coca = new Product("Coca", 10.5, refrigerante);
		Product fanta = new Product("Coca", 8.5, refrigerante);
		Product dolly = new Product("Coca", 6.0, refrigerante);
		
		Order order = new Order(new Date(), new Date());
		order.setPerson(person);
		order.addOrderItem(new OrderItem(order, coca, 5));
		order.addOrderItem(new OrderItem(order, fanta, 5));
		order.addOrderItem(new OrderItem(order, dolly, 5));
		
		OrderDAO dao = new OrderDAO();
		dao.persist(order);
	}

}
