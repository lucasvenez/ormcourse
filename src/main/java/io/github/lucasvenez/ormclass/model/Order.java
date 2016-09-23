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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "`Order`")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4124110809141682575L;

	@Id
	@Column
	@GeneratedValue
	private Integer idOrder;
	
	@Column(name = "`date`", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name = "`time`", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date time;

	@OneToMany(
			mappedBy = "order", 
			targetEntity = OrderItem.class, 
			fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL)
	private final List<OrderItem> orderItems = new ArrayList<OrderItem>();

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idPerson", nullable = false)
	private Person person;

	public Order(Date date, Date time) {
		this.date = date;
		this.time = time;
	}
	
	public Order(Date date, Date time, Person person) {
		this.date = date;
		this.time = time;
		setPerson(person);
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		person.addOrder(this);
		this.person = person;
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
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void addOrderItem(OrderItem orderItem) {
		orderItem.setOrder(this);
		this.orderItems.add(orderItem);
	}
	
	public void addOrderItems(OrderItem ... orderItems) {
		for (OrderItem oi : orderItems)
			this.addOrderItem(oi);
	}
}
