package com.coforge.ars.service;

import java.util.List;


import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.coforge.ars.exception.AirportNotFoundException;
import com.coforge.ars.model.Airport;
import com.coforge.ars.repo.AirportRepo;



@Service
public class AirportServiceImpl implements AirportService {
	private AirportRepo repo;
	private Environment environment;
	public AirportServiceImpl (AirportRepo repo,Environment environment) {
		this.repo = repo;
		this.environment = environment;
	}
	
	@Override
	public boolean saveAirport(Airport airport) {
		repo.save(airport);
		return true;
	}
	
	@Override
	public boolean updateAirport(Integer airportId, Airport airport) {
		if(!repo.existsById(airportId)) {
			throw new AirportNotFoundException(
			environment.getProperty("airport.invalid.notfound"));
		}
		airport.setAirportId(airportId);
		repo.save(airport);
		return true;
	}
	@Override
	public boolean deleteAirportById(Integer airportId) {
		if(!repo.existsById(airportId)) {
			throw new AirportNotFoundException(
			environment.getProperty("airport.invalid.notfound"));
		}

		repo.deleteById(airportId);
		return true;
	}
	@Override
	public Optional<Airport> findByAirportId(Integer airportId) {
		if(!repo.existsById(airportId)) {
			throw new AirportNotFoundException(
					environment.getProperty("airport.invalid.notfound"));	
		}
		return repo.findById(airportId);
	}
	@Override
	public List<Airport> findAllAirports() {
		return (List<Airport>) repo.findAll();
	}
	
	
	
}
