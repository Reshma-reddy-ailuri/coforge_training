package com.coforge.ars.service;

import java.util.List;
import java.util.Optional;

import com.coforge.ars.model.Booking;

public interface BookingService {

	boolean saveBooking(Booking booking);

	boolean updateBooking(Integer bookingId, Booking booking);

	boolean deleteBookingById(Integer bookingId);

	Optional<Booking> findByBookingId(Integer bookingId);

	List<Booking> findAllBookings();
	
	List<Booking> findBookingsByCustomerId(Integer customerId);

}