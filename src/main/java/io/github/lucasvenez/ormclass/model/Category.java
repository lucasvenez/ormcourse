package io.github.lucasvenez.ormclass.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private Integer idCategory;
	
	private String name;
	
	private final List<Product> products = new ArrayList<Product>();

	public Integer getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
	}
}
