package io.github.lucasvenez.ormclass.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8828537561369513397L;

	@Id
	@Column
	@GeneratedValue
	private Integer idCategory;
	
	@Column
	private String name;
	
	@OneToMany(
			mappedBy = "category", 
			targetEntity = Product.class, 
			fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL)
	private final List<Product> products = new ArrayList<Product>();

	public Category(String name) {
		this.name = name;
	}

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
