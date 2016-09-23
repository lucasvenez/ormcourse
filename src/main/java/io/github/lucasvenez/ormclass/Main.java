package io.github.lucasvenez.ormclass;

import java.util.Date;

import io.github.lucasvenez.ormclass.dao.OrderDAO;
import io.github.lucasvenez.ormclass.model.Category;
import io.github.lucasvenez.ormclass.model.Order;
import io.github.lucasvenez.ormclass.model.OrderItem;
import io.github.lucasvenez.ormclass.model.Person;
import io.github.lucasvenez.ormclass.model.Product;

public class Main {

	public static void main(String[] args) {
		
		Person person = new Person("John Doe");
		Category cat =  new Category("informatica");
		Product prod = new Product("Um lindo Monitor", cat);
		Order order = new Order(new Date(), new Date(), person);
		OrderItem oi = new OrderItem(order, prod, 1);
		OrderDAO dao = new OrderDAO();
		
		dao.persist(order);
	}

}
