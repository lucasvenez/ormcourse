package io.github.lucasvenez.ormclass.model;

import java.util.ArrayList;
import java.util.List;

public class State {

	private String idState;
	
	private String name;

	private final List<City> cities = new ArrayList<City>();
	
	private Country country;
	
	public String getIdState() {
		return idState;
	}

	public void setIdState(String idState) {
		this.idState = idState;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<City> getCities() {
		return cities;
	}

	public void addCity(City city) {
		this.cities.add(city);
	}
}
