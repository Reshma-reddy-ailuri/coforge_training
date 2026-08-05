package com.coforge.ars.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.coforge.ars.model.Airport;


@Repository
public interface AirportRepo extends CrudRepository<Airport, Integer> {

}
