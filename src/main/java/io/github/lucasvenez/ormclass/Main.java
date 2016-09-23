package io.github.lucasvenez.ormclass;

import java.util.Date;

import io.github.lucasvenez.ormclass.dao.OrderDAO;
import io.github.lucasvenez.ormclass.model.City;
import io.github.lucasvenez.ormclass.model.Country;
import io.github.lucasvenez.ormclass.model.Order;
import io.github.lucasvenez.ormclass.model.Person;
import io.github.lucasvenez.ormclass.model.State;
import io.github.lucasvenez.ormclass.utils.EasyDate;

public class Main {

	public static void main(String[] args) {
		
		Country country = new Country("Brazil");
		
		State state = new State("São Paulo", country);
		
		City city = new City("Caraguatatuba", state);
		
		Person person = new Person();
		person.setFullname("Hugo Salles Cuba");
		
		//EasyDate date = new EasyDate(2016, 9, 22);
				
		Order order = new Order();
		order.setDate(new Date());
		order.setTime(new Date());

		OrderDAO dao = new OrderDAO();
		
		dao.persist(order);
	}

}
