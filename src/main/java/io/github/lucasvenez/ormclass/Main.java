package io.github.lucasvenez.ormclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import io.github.lucasvenez.ormclass.dao.OrderDAO;
import io.github.lucasvenez.ormclass.model.Category;
import io.github.lucasvenez.ormclass.model.City;
import io.github.lucasvenez.ormclass.model.Country;
import io.github.lucasvenez.ormclass.model.Individual;
import io.github.lucasvenez.ormclass.model.Order;
import io.github.lucasvenez.ormclass.model.OrderItem;
import io.github.lucasvenez.ormclass.model.Person;
import io.github.lucasvenez.ormclass.model.Product;
import io.github.lucasvenez.ormclass.model.State;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Country country = new Country("Brazil");
		State state = new State("São Paulo", country);
		City city = new City("Caraguatatuba", state);
		
		Person person = new Person();
		person.setFullname("Hugo Salles Cuba");
		person.setCity(city);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date aniversario = sdf.parse("31/03/1988");
		person.setBirthdate(aniversario);
		
		Category category = new Category("Frutas");
		
		Product product1 = new Product("Maça", 1.0, category);
		Product product2 = new Product("Uva", 2.0, category);
		Product product3 = new Product("Pera", 3.0, category);
		
		Date date = sdf.parse("23/09/2016");
		SimpleDateFormat ft = new SimpleDateFormat ("hh:mm:ss");
		Date hour = ft.parse("15:51:00");

		Order order = new Order(date, hour);
		
		OrderItem orderitem1 = new OrderItem(order, product1, 1);
		OrderItem orderitem2 = new OrderItem(order, product3, 2);
		OrderItem orderitem3 = new OrderItem(order, product2, 4);
		
		order.setPerson(person);
		
		OrderDAO dao = new OrderDAO();
		dao.persist(order);
		
		System.out.println("Data: " + order.getDate() + " - " + order.getTime());
		System.out.println("Cliente: " + order.getPerson().getFullname() + ", " + order.getPerson().getCity().getName() + " - " + order.getPerson().getCity().getState().getName());
		for(OrderItem o : order.getOrderItems()){
			System.out.println(o.getProduct().getName() + " - " + o.getQuantity() + o.getProduct().getCategory().getName());
		}
		
	}

}
