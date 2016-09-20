package io.github.lucasvenez.ormclass.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class City implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5387835097313019330L;

	@Id
	@Column
	@GeneratedValue
	private Integer idCity;
	
	@Column
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="idState", nullable = false)
	private State state;

	public City(String name, State state) {
		this.name = name;
		this.setState(state);
	}

	public Integer getIdCity() {
		return idCity;
	}

	public void setIdCity(Integer idCity) {
		this.idCity = idCity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		state.addCity(this);
		this.state = state;
	}
}
