package com.coforge.ars.service;

import java.util.List;

import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.coforge.ars.exception.AirplaneNotFoundException;
import com.coforge.ars.model.Airplane;
import com.coforge.ars.repo.AirplaneRepo;


@Service
public class AirplaneServiceImpl implements AirplaneService {
	private AirplaneRepo repo;
	private Environment environment;
	public AirplaneServiceImpl (AirplaneRepo repo,Environment environment) {
		this.repo = repo;
		this.environment = environment;
	}
	
	@Override
	public boolean saveAirplane(Airplane airplane) {
		repo.save(airplane);
		return true;
	}
	
	@Override
	public boolean updateAirplane(Integer airplaneId, Airplane airplane) {
		if(!repo.existsById(airplaneId)) {
			throw new AirplaneNotFoundException(
			environment.getProperty("airplane.invalid.notfound"));
		}
		airplane.setAirplaneId(airplaneId);
		repo.save(airplane);
		return true;
	}
	@Override
	public boolean deleteAirplaneById(Integer airplaneId) {
		if(!repo.existsById(airplaneId)) {
			throw new AirplaneNotFoundException(
			environment.getProperty("airplane.invalid.notfound"));
		}

		repo.deleteById(airplaneId);
		return true;
	}
	@Override
	public Optional<Airplane> findByAirplaneId(Integer airplaneId) {
		if(!repo.existsById(airplaneId)) {
			throw new AirplaneNotFoundException(
					environment.getProperty("airplane.invalid.notfound"));	
		}
		return repo.findById(airplaneId);
	}
	@Override
	public List<Airplane> findAllAirplanes() {
		return (List<Airplane>) repo.findAll();
	}
	
	
	
}
