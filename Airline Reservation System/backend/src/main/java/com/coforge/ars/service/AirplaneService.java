package com.coforge.ars.service;

import java.util.List;

import java.util.Optional;

import com.coforge.ars.model.Airplane;


public interface AirplaneService {
	boolean saveAirplane(Airplane airplane);
	boolean updateAirplane(Integer airplaneId,Airplane airplane);
	boolean deleteAirplaneById(Integer airplaneId);
	Optional<Airplane> findByAirplaneId(Integer airplaneId);
	List<Airplane> findAllAirplanes();
}
