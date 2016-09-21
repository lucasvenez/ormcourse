package io.github.lucasvenez.ormclass.model;

import java.io.Serializable;
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
public class State implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5568640712434775294L;

	@Id
	@Column
	@GeneratedValue
	private Integer idState;
	
	@Column
	private String name;

	@OneToMany(
		cascade = CascadeType.ALL,
		mappedBy = "state",
		targetEntity = City.class,
		fetch = FetchType.LAZY)
	private final List<City> cities = new ArrayList<City>();
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idCountry", nullable = false)
	private Country country;
	
	public State(String name, Country country) {
		this.name = name;
		this.setCountry(country);
	}

	public Integer getIdState() {
		return idState;
	}

	public void setIdState(Integer idState) {
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
		country.addState(this);
		this.country = country;
	}

	public List<City> getCities() {
		return cities;
	}

	public void addCity(City city) {
		this.cities.add(city);
	}
}
