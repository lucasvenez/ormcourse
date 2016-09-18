package io.github.lucasvenez.ormclass;

import io.github.lucasvenez.ormclass.dao.OrderDAO;
import io.github.lucasvenez.ormclass.dao.ProductDAO;
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
		
		/*ProductDAO dao = new ProductDAO();
		
		Category category = new Category();
		
		category.setName("C1");
		
		Product product = new Product();
		
		product.setCategory(category);
		
		product.setPrice(12.50);
		
		dao.persist(product);*/
		
		//Pessoas, vendas, produtos e item venda!!! Dar pull request para o prof no github
		//Dar persist só no OrderDAO já dá persiste nas outras.
		Country country = new Country();
		
		State state = new State();
		
		City city = new City();
		
		country.setName("Brasil");
		
		state.setName("São Paulo");
		
		city.setName("Caraguatatuba");
		
		city.setState(state);
		
		/**************************************************************/
		
		OrderDAO dao = new OrderDAO();
		
		Person person = new Person();
		
		Category category1 = new Category();
		Category category2 = new Category();
		Category category3 = new Category();
		
		Product product1 = new Product();
		Product product2 = new Product();
		Product product3 = new Product();
		
		Order order = new Order();
		
		OrderItem orderItem1 = new OrderItem();
		OrderItem orderItem2 = new OrderItem();
		OrderItem orderItem3 = new OrderItem();
	
		person.setFullname("Yasmin Sayad Yoshizumi");
		
		person.setCity(city);
		
		person.setBirthdate(?);
		
		category1.setName("Alimentos");
		category2.setName("Bedidas");
		category3.setName("Cigarros");
		
		product1.setName("Pão de queijo");
		product2.setName("Coca-cola");
		product3.setName("Hollywood Azul Box");
		
		product1.setCategory(category1);
		product2.setCategory(category2);
		product3.setCategory(category3);
		
		product1.setPrice(8.45);
		product2.setPrice(5.79);
		product3.setPrice(7.50);
		
		order.setOrderDate(?);
		
		order.setOrderTime(?);
		
		order.setPerson(person);
		
		order.setOrderTime(null);
		
		orderItem1.setOrder(order);
		orderItem2.setOrder(order);
		orderItem3.setOrder(order);
		
		orderItem1.setProduct(product1);
		orderItem2.setProduct(product2);
		orderItem3.setProduct(product3);
		
		orderItem1.setQuantity(2);
		orderItem2.setQuantity(1);
		orderItem3.setQuantity(3);
		
		dao.persist(order);
		
		
	}

}
