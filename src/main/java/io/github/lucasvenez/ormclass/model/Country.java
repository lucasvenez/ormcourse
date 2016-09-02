package io.github.lucasvenez.ormclass.model;

import java.util.ArrayList;
import java.util.List;

public class Country {

	private Integer idCountry;
	
	private String name;
	
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
