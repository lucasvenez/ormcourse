package io.github.lucasvenez.ormclass.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
@IdClass(OrderItemPK.class)
public class OrderItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8649028181564316740L;

	//@Id
	//@Column(name = "idOrder", insertable = false, updatable = false)
	private Integer idOrder;

	//@Id
	//@Column(name = "idProduct", insertable = false, updatable = false)
	private Integer idProduct;

	@Id
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "idOrder", referencedColumnName = "idOrder")
	private Order order;

	@Id
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "idProduct", referencedColumnName = "idProduct")
	private Product product;

	@Column
	private Integer quantity;

	public OrderItem(){
		
	}
	
	public OrderItem(Order order, Product product, Integer quantity) {
		//this.idOrder = order.getIdOrder();
		this.order = order;
		//this.idProduct = product.getIdProduct();
		this.product = product;
		this.quantity = quantity;
	}

	
	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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
