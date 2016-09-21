package io.github.lucasvenez.ormclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.github.lucasvenez.ormclass.dao.CityDAO;
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

	public static void main(String[] args) throws ParseException {
		CityDAO daoCity = new CityDAO();
		
		Country country = new Country("Brasil");
		
		State state = new State("São Paulo", country);
		
		City city = new City("Caraguatatuba", state);
		
		daoCity.persist(city);
		
		/**************************************************************/
		
		OrderDAO dao = new OrderDAO();
		
		Person person = new Person();
		
		person.setFullname("Yasmin Sayad Yoshizumi");
		
		person.setCity(city);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d1 = sdf.parse("17/11/1991");
		person.setBirthdate(d1);
		
		Category category1 = new Category("Alimentos");
		Category category2 = new Category("Bedidas");
		Category category3 = new Category("Cigarros");
		
		Product product1 = new Product("Pão de queijo", 8.45, category1);
		Product product2 = new Product("Coca-cola", 5.79, category2);
		Product product3 = new Product("Hollywood Azul Box", 7.50, category3);
		
		Date d2 = sdf.parse("18/09/2016");
		
		SimpleDateFormat ft = new SimpleDateFormat ("hh:mm:ss");
		Date t1 = ft.parse("13:27:40");
		
		Order order = new Order(d2, t1);
		
		OrderItem orderItem1 = new OrderItem(order, product1, 2);
		OrderItem orderItem2 = new OrderItem(order, product2, 1);
		OrderItem orderItem3 = new OrderItem(order, product3, 3);
		
		order.setPerson(person);
		
		dao.persist(order);
	}

}
