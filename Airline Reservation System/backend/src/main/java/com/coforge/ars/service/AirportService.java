package com.coforge.ars.service;

import java.util.List;

import java.util.Optional;

import com.coforge.ars.model.Airport;


public interface AirportService {
	boolean saveAirport(Airport airport);
	boolean updateAirport(Integer airportId,Airport airport);
	boolean deleteAirportById(Integer airportId);
	Optional<Airport> findByAirportId(Integer airportId);
	List<Airport> findAllAirports();
}
