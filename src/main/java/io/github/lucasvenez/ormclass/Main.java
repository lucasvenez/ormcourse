package io.github.lucasvenez.ormclass;

import java.util.Date;

import io.github.lucasvenez.ormclass.dao.OrderDAO;
import io.github.lucasvenez.ormclass.model.Order;
import io.github.lucasvenez.ormclass.model.Person;

public class Main {

	public static void main(String[] args) {
		
		Person person = new Person();
		
		person.getBirthdate();
		
		person.getCity();
		
		Order order = new Order();
		
		order.setOrderDate(new Date());
		
		order.setOrderTime(new Date());
		
		//..

		OrderDAO dao = new OrderDAO();
		
		dao.persist(order);
	}

}
