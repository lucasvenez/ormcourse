package io.github.lucasvenez.ormclass.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3240983089242859803L;

	@Id
	@Column
	@GeneratedValue
	private Integer idProduct;
	
	@Column
	private String name;
	
	@Column
	private Double price;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="idCategory", nullable = false)
	private Category category;

	public Product(String name, Category category) {
		this.name = name;
		this.category = category;
		category.addProduct(this);
		
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		category.addProduct(this);
		this.category = category;
	}
}
