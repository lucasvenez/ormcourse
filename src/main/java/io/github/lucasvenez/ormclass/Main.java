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
		
		Country country = new Country("Brasil");
		State state = new State("São Paulo", country);
		City city = new City("Caraguatatuba", state);
		
		Person person = new Person();
		person.setFullname("Cleyton de Castro Mario");
		person.setCity(city);
		
		Order order = new Order();
		order.setPerson(person);
		order.setDate(new Date());
		order.setTime(new Date());
		
		Category category = new Category("Bebidas");
		
		Product produto1 = new Product("Coca-Cola", 3.5, category);
		Product produto2 = new Product("Guaraná", 3.5, category);
		Product produto3 = new Product("Sukita", 3.5, category);
		
		OrderItem orderItem1 = new OrderItem(order, produto1, 10);
		OrderItem orderItem2 = new OrderItem(order, produto2, 1);
		OrderItem orderItem3= new OrderItem(order, produto3, 5);
		
		order.addOrderItem(orderItem1);
		order.addOrderItem(orderItem1);
		order.addOrderItem(orderItem1);
		
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.persist(order);
		
	}

}
