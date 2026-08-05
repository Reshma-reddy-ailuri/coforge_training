package com.coforge.ars.service;

import java.util.List;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.coforge.ars.exception.PassengerNotFoundException;
import com.coforge.ars.model.Passenger;
import com.coforge.ars.repo.PassengerRepo;

@Service
public class PassengerServiceImpl implements PassengerService {

	private PassengerRepo repo;
	private Environment environment;

	public PassengerServiceImpl(PassengerRepo repo, Environment environment) {
		this.repo = repo;
		this.environment = environment;
	}

	@Override
	public boolean savePassenger(Passenger passenger) {

		repo.save(passenger);
		return true;
	}

	@Override
	public boolean updatePassenger(Integer passengerId, Passenger passenger) {

		if (!repo.existsById(passengerId)) {
			throw new PassengerNotFoundException(
					environment.getProperty("passenger.invalid.notfound"));
		}

		passenger.setPassengerId(passengerId);

		repo.save(passenger);
		return true;
	}

	@Override
	public boolean deletePassengerById(Integer passengerId) {

		if (!repo.existsById(passengerId)) {
			throw new PassengerNotFoundException(
					environment.getProperty("passenger.invalid.notfound"));
		}

		repo.deleteById(passengerId);
		return true;
	}

	@Override
	public Optional<Passenger> findByPassengerId(Integer passengerId) {

		if (!repo.existsById(passengerId)) {
			throw new PassengerNotFoundException(
					environment.getProperty("passenger.invalid.notfound"));
		}

		return repo.findById(passengerId);
	}

	@Override
	public List<Passenger> findAllPassengers() {

		return (List<Passenger>) repo.findAll();
	}

}