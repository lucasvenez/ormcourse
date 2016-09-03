package io.github.lucasvenez.ormclass;

import io.github.lucasvenez.ormclass.dao.ProductDAO;
import io.github.lucasvenez.ormclass.model.Category;
import io.github.lucasvenez.ormclass.model.Product;

public class Main {

	public static void main(String[] args) {
		
		ProductDAO dao = new ProductDAO();
		
		Category category = new Category();
		
		category.setName("C1");
		
		Product product = new Product();
		
		product.setCategory(category);
		
		product.setName("P1");
		
		product.setPrice(12.50);
		
		dao.persist(product);
	}

}
