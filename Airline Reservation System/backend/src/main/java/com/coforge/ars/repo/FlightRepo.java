package com.coforge.ars.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.ars.model.Flight;

@Repository
public interface FlightRepo extends CrudRepository<Flight, Integer> {

	List<Flight> findByDepartureAirport_AirportIdAndArrivalAirport_AirportIdAndDepartureTimeBetween(
			Integer departureAirportId,
			Integer arrivalAirportId,
			LocalDateTime startTime,
			LocalDateTime endTime);

}