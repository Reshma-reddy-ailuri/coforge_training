package com.coforge.ars.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.ars.model.Booking;

@Repository
public interface BookingRepo extends CrudRepository<Booking, Integer>{

	List<Booking> findByCustomerId(Integer customerId);

}