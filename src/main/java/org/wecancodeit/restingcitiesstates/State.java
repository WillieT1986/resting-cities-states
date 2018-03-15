package org.wecancodeit.restingcitiesstates;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class State {

	@Id
	@GeneratedValue
	private long id;
	private String stateName;

	@OneToMany
	private Collection<Cities> cities;

	public State() {

	}

	public State(String stateName, Cities... cities) {
		this.stateName = stateName;
		this.cities = new HashSet<>(asList(cities));
	}

	public long getId() {
		return id;
	}

	public String getStateName() {
		return stateName;
	}

	public Collection<Cities> getCities() {
		return cities;
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((State) obj).id;
	}

}
