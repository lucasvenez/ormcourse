package io.github.lucasvenez.ormclass.dao;

import java.util.List;

import io.github.lucasvenez.ormclass.model.City;

public class CityDAO extends DAO<City> {

	@SuppressWarnings("unchecked")
	@Override
	public List<City> findAll() {
		return entityManager.createQuery("FROM City").getResultList();
	}

	@Override
	public City getById(Long id) {
		return entityManager.find(City.class, id);
	}

	@Override
	public boolean removeById(Long id) {
		boolean result = true;

		try {
			City city = this.getById(id);
			super.remove(city);
		} catch (Exception ex) {
			ex.printStackTrace();
			result = false;
		}

		return result;
	}
	
}
