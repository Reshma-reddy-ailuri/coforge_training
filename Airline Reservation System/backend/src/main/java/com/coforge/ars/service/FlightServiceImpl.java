package com.coforge.ars.service;

import java.time.LocalDateTime;
import java.util.List;

import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.coforge.ars.exception.FlightNotFoundException;
import com.coforge.ars.model.Flight;
import com.coforge.ars.repo.FlightRepo;

@Service
public class FlightServiceImpl implements FlightService {
	private FlightRepo repo;
	private Environment environment;

	public FlightServiceImpl(FlightRepo repo, Environment environment) {
		this.repo = repo;
		this.environment = environment;
	}

	@Override
	public boolean saveFlight(Flight flight) {
		repo.save(flight);
		return true;
	}

	@Override
	public boolean updateFlight(Integer flightId, Flight flight) {
		if (!repo.existsById(flightId)) {
			throw new FlightNotFoundException(environment.getProperty("flight.invalid.notfound"));
		}
		flight.setFlightId(flightId);
		repo.save(flight);
		return true;
	}

	@Override
	public boolean deleteFlightById(Integer flightId) {
		if (!repo.existsById(flightId)) {
			throw new FlightNotFoundException(environment.getProperty("flight.invalid.notfound"));
		}

		repo.deleteById(flightId);
		return true;
	}

	@Override
	public Optional<Flight> findByFlightId(Integer flightId) {
		if (!repo.existsById(flightId)) {
			throw new FlightNotFoundException(environment.getProperty("flight.invalid.notfound"));
		}
		return repo.findById(flightId);
	}

	@Override
	public List<Flight> findAllFlights() {
		return (List<Flight>) repo.findAll();
	}

	// to update flight status
	@Override
	public boolean updateFlightStatus(Integer flightId, String flightStatus) {
		if (!repo.existsById(flightId)) {
			throw new FlightNotFoundException(environment.getProperty("flight.invalid.notfound"));
		}
		Flight flight = repo.findById(flightId).get();
		flight.setFlightStatus(flightStatus);
		repo.save(flight);
		return true;
	}

	@Override
	public List<Flight> searchFlights(Integer departureAirportId,
			Integer arrivalAirportId,
			LocalDateTime journeyDate) {

		LocalDateTime start = journeyDate.toLocalDate().atStartOfDay();
		LocalDateTime end = journeyDate.toLocalDate().atTime(23, 59, 59);

		List<Flight> flights = repo
				.findByDepartureAirport_AirportIdAndArrivalAirport_AirportIdAndDepartureTimeBetween(
						departureAirportId,
						arrivalAirportId,
						start,
						end);

		flights.removeIf(flight ->
				flight.getFlightStatus().equalsIgnoreCase("CANCELLED")
				|| flight.getFlightStatus().equalsIgnoreCase("COMPLETED"));

		return flights;
	}

}
