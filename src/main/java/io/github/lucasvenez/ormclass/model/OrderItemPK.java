package io.github.lucasvenez.ormclass.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class OrderItemPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idOrder", insertable = false, updatable = false)
	private Integer idOrder;

	@Id
	@Column(name = "idProduct", insertable = false, updatable = false)
	private Integer idProduct;

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

	public OrderItemPK() {
	}

	@Override
    public int hashCode() {
        return idOrder + idProduct;
    }
 
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof OrderItemPK){
        	OrderItemPK orderItemPK = (OrderItemPK) obj;
            return orderItemPK.idOrder == idOrder && orderItemPK.idProduct == idProduct;
        }
 
        return false;
    }
}
