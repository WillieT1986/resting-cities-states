package org.wecancodeit.restingcitiesstates;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class State {

	@Id
	@GeneratedValue
	private long id;

	public long getId() {
		return id;
	}

	public String getStateName() {
		return null;
	}

}
