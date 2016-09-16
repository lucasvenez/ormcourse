package io.github.lucasvenez.ormclass.model;

import java.util.ArrayList;
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

@Entity
@Table
public class State {

	@Id
	@Column
	@GeneratedValue
	private String idState;
	
	@Column
	private String name;

	@OneToMany(
		cascade = CascadeType.ALL,
		mappedBy = "city",
		targetEntity = City.class,
		fetch = FetchType.LAZY)
	private final List<City> cities = new ArrayList<City>();
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idCountry", nullable = false)
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
