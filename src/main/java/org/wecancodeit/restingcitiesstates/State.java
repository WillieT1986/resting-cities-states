package org.wecancodeit.restingcitiesstates;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class State {

	@Id
	@GeneratedValue
	private long id;
	private String stateName;

	public State() {

	}

	public State(String stateName) {
		this.stateName = stateName;
	}

	public long getId() {
		return id;
	}

	public String getStateName() {
		return stateName;
	}

}
