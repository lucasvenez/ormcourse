package io.github.lucasvenez.ormclass.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Country {

	@Id
	@Column
	@GeneratedValue
	private Integer idCountry;
	
	@Column
	private String name;
	
	@OneToMany(
		mappedBy = "state",
		fetch = FetchType.LAZY,
		targetEntity = State.class,
		cascade = CascadeType.ALL)
	private final List<State> states = new ArrayList<State>();

	public Integer getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Integer idCountry) {
		this.idCountry = idCountry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<State> getStates() {
		return states;
	}
	
	public void addState(State state) {
		this.states.add(state);
	}
}
