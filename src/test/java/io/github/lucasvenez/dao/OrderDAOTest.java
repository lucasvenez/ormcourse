package io.github.lucasvenez.dao;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

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

	private Order order;
	
	private final OrderDAO dao = new OrderDAO();
	
	@Before
	public void setUp() {

		/*
		 * Creating country, state, and city
		 */
		City city = 
			new City("Caraguatatuba", 
				new State("São Paulo", 
					new Country("Brazil")));
		
		/*
		 * Creating person:
		 * - Fullname: Lucas Venezian Povoa
		 * - Birthdate: 01/02/1990
		 * - City: Caraguatatuba
		 */
		Person person = new Person();
		
		person.setFullname("Lucas Venezian Povoa");
		
		/*
		 * Creating a date: 1990-02-01
		 */
		Date birthdate = java.sql.Date.valueOf(LocalDate.of(1990, Month.FEBRUARY, 1));
		
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
	}
	
	@Test
	public void orderTest() {
		assertTrue(dao.persist(order));
	}
	
	@Test
	public void orderSearchByIntervalTest() {
		
		Date start = 
			java.sql.Date.valueOf(
				LocalDate.of(2016, Month.SEPTEMBER, 1));
		
		Date end = new Date();
		
		assertTrue(dao.findByInterval(start, end).size() > 0);
	}
}
