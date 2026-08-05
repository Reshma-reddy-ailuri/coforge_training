package com.coforge.ars.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_flight")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer flightId;
	
	@ManyToOne
	@JoinColumn(name="airplane_id")
	private Airplane airplane;
	
	@ManyToOne
	@JoinColumn(name="departure_airport_id")
	private Airport departureAirport;
	
	@ManyToOne
	@JoinColumn(name="arrival_airport_id")
	private Airport arrivalAirport;
	
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	
	private String flightStatus;
	private double economyFare;
	private double businessFare;
	private double firstClassFare;
	public Flight() {
		super();
	}
	public Integer getFlightId() {
	    return flightId;
	}
	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}
	public Airplane getAirplane() {
		return airplane;
	}
	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}
	public Airport getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}
	public Airport getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getFlightStatus() {
		return flightStatus;
	}
	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}
	public double getEconomyFare() {
		return economyFare;
	}
	public void setEconomyFare(double economyFare) {
		this.economyFare = economyFare;
	}
	public double getBusinessFare() {
		return businessFare;
	}
	public void setBusinessFare(double businessFare) {
		this.businessFare = businessFare;
	}
	public double getFirstClassFare() {
		return firstClassFare;
	}
	public void setFirstClassFare(double firstClassFare) {
		this.firstClassFare = firstClassFare;
	}
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", airplane=" + airplane + ", departureAirport=" + departureAirport
				+ ", arrivalAirport=" + arrivalAirport + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", flightStatus=" + flightStatus + ", economyFare=" + economyFare + ", businessFare="
				+ businessFare + ", firstClassFare=" + firstClassFare + "]";
	}
	
	
	
	
	
}
