package io.github.lucasvenez.ormclass.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4124110809141682575L;

	@Id
	@Column
	@GeneratedValue
	private Integer idOrder;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIME)
	private Date time;

	@OneToMany(
			mappedBy = "order", 
			targetEntity = OrderItem.class, 
			fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL)
	private final List<OrderItem> orderItems = new ArrayList<OrderItem>();

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void addOrderItems(OrderItem orderItem) {
		orderItem.setOrder(this);
		this.orderItems.add(orderItem);
	}
	
	
	
}
