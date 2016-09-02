package io.github.lucasvenez.ormclass.model;

public class OrderItem {

	private Order orider;
	
	private Product product;
	
	private Integer quantity;

	public Order getOrider() {
		return orider;
	}

	public void setOrider(Order orider) {
		this.orider = orider;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
