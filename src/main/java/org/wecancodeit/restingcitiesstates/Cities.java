package org.wecancodeit.restingcitiesstates;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cities {

	@Id
	@GeneratedValue
	private long id;
	private String cityName;

	@ManyToOne
	private State state;

	public Cities() {

	}

	public Cities(String cityName, State state) {
		this.state = state;
		this.cityName = cityName;
	}

	public long getId() {
		return id;
	}

	public String getCityName() {
		return cityName;
	}

	public State getState() {
		return state;
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
		return id == ((Cities) obj).id;
	}
}