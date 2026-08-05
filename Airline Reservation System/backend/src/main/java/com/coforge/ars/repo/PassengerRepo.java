package com.coforge.ars.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.ars.model.Passenger;

@Repository
public interface PassengerRepo extends CrudRepository<Passenger, Integer>{

}