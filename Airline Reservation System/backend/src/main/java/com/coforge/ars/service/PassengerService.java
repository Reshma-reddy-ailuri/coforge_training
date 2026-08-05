package com.coforge.ars.service;

import java.util.List;
import java.util.Optional;

import com.coforge.ars.model.Passenger;

public interface PassengerService {

	boolean savePassenger(Passenger passenger);

	boolean updatePassenger(Integer passengerId, Passenger passenger);

	boolean deletePassengerById(Integer passengerId);

	Optional<Passenger> findByPassengerId(Integer passengerId);

	List<Passenger> findAllPassengers();

}