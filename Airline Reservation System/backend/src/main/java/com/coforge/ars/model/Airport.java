package com.coforge.ars.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_airport")
public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer airportId;
	private String airportName;
	private String city;
	private String airportCode;

	public Airport() {
		super();
	}

	public Airport(Integer airportId, String airportName, String city, String airportCode) {
		super();
		this.airportId = airportId;
		this.airportName = airportName;
		this.city = city;
		this.airportCode = airportCode;
	}

	public int getAirportId() {
		return airportId;
	}

	public void setAirportId(Integer airportId) {
		this.airportId = airportId;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	@Override
	public String toString() {
		return "Airport [airportId=" + airportId + ", airportName=" + airportName + ", city=" + city + ", airportCode="
				+ airportCode + "]";
	}

}
