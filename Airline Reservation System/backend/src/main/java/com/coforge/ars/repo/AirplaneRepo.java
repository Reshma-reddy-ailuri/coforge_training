package com.coforge.ars.repo;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.coforge.ars.model.Airplane;

@Repository
public interface AirplaneRepo extends CrudRepository<Airplane , Integer> {

}
