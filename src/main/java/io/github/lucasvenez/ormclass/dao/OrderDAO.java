package io.github.lucasvenez.ormclass.dao;

import io.github.lucasvenez.ormclass.model.Order;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

public class OrderDAO extends DAO<Order> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAll() {
		return entityManager.createQuery("FROM Order").getResultList();
	}

	@Override
	public Order getById(Long id) {
		return entityManager.find(Order.class, id);
	}

	@Override
	public boolean removeById(final Long id) {

		boolean result = true;

		try {
			Order order = this.getById(id);
			super.remove(order);
		} catch (Exception ex) {
			ex.printStackTrace();
			result = false;
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Order> findByInterval(Date startIncluded, Date endIncluded) {
		
		Query query = 
			entityManager.createQuery(
				"FROM Product WHERE date BETWEEN :startDate AND :endDate");

		query.setParameter("startDate", startIncluded);
		
		query.setParameter("endDate", endIncluded);
		
		return query.getResultList();
	}

}
