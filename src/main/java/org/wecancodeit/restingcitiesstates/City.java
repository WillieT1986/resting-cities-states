package org.wecancodeit.restingcitiesstates;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class City {

	@Id
	@GeneratedValue
	private long id;
	private String cityName;

	public City() {

	}

	public City(String cityName) {
		this.cityName = cityName;
	}

	public long getId() {
		return id;
	}

	public String getCityName() {
		return cityName;
	}

}
