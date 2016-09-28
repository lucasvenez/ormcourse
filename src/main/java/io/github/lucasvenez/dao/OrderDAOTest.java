package io.github.lucasvenez.dao;

import java.time.LocalDate;
import java.time.Month;
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

public class OrderDAOTest {

	private Order order = new Order();
	
	private final OrderDAO dao = new OrderDAO();
	
	public void setUp(String nome, String cidade, String estado, String pais) {

		/*
		 * Creating country, state, and city
		 */
		City city = 
			new City(cidade, 
				new State(estado, 
					new Country(pais)));
		
		Person person = new Person();
		
		person.setFullname(nome);
		
		Date birthdate = java.sql.Date.valueOf(LocalDate.of(1995, Month.AUGUST, 9));
		
		person.setBirthdate(birthdate);
		
		person.setCity(city);
		
		/*
		 * Creating categories
		 */
		Category c1 = new Category("Drink");
		
		Category c2 = new Category("Food");
		
		/*
		 * Creating products
		 */
		Product p1 = new Product("Soda", 3.0,  c1);
		
		Product p2 = new Product("Bean", 10.0, c2);
		
		Product p3 = new Product("Rise", 8.0,  c2);

		/*
		 * Creating order
		 */
		this.order = new Order(new Date(), new Date());
		
		this.order.setPerson(person);
		
		/*
		 * Creating Order Item
		 */
		OrderItem oi1 = new OrderItem(order, p1, 10);
		
		OrderItem oi2 = new OrderItem(order, p2, 2);
		
		OrderItem oi3 = new OrderItem(order, p3, 4);

		/*
		 * Adding order items to order
		 */
		this.order.addOrderItems(oi1, oi2, oi3);
                
                dao.persist(order);
	}
}
