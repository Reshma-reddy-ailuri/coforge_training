package com.coforge.ars.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.coforge.ars.exception.BookingNotFoundException;
import com.coforge.ars.exception.InsufficientBalanceException;
import com.coforge.ars.exception.WalletNotFoundException;
import com.coforge.ars.model.Booking;
import com.coforge.ars.model.Wallet;
import com.coforge.ars.repo.BookingRepo;
import com.coforge.ars.repo.WalletRepo;


@Service
public class BookingServiceImpl implements BookingService {

	private BookingRepo repo;
	private WalletRepo walletRepo;
	private Environment environment;
	
	//for single constructor it's optional to use autowired
	public BookingServiceImpl(BookingRepo repo, WalletRepo walletRepo, Environment environment) {
		this.repo = repo;
		this.walletRepo = walletRepo;
		this.environment = environment;
	}

	@Override
	public boolean saveBooking(Booking booking) {

		Optional<Wallet> optional = walletRepo.findByCustomerId(booking.getCustomerId());
		booking.setBookingDate(new Timestamp(System.currentTimeMillis()));

		if (optional.isEmpty()) {
			throw new WalletNotFoundException(
					environment.getProperty("wallet.invalid.notfound"));
		}

		Wallet wallet = optional.get();

		// Check Wallet Balance
		if (wallet.getBalance().compareTo(booking.getTotalAmount()) < 0) {

			throw new InsufficientBalanceException(
					environment.getProperty("wallet.insufficient.balance"));
		}

		// Deduct Booking Amount
		wallet.setBalance(
				wallet.getBalance().subtract(booking.getTotalAmount()));

		// Save Updated Wallet
		walletRepo.save(wallet);

		// Save Booking
		repo.save(booking);

		return true;
	}

	@Override
	public boolean updateBooking(Integer bookingId, Booking booking) {

		if (!repo.existsById(bookingId)) {
			throw new BookingNotFoundException(
					environment.getProperty("booking.invalid.notfound"));
		}

		booking.setBookingId(bookingId);

		repo.save(booking);
		return true;
	}

	@Override
	public boolean deleteBookingById(Integer bookingId) {

		if (!repo.existsById(bookingId)) {
			throw new BookingNotFoundException(
					environment.getProperty("booking.invalid.notfound"));
		}

		repo.deleteById(bookingId);
		return true;
	}

	@Override
	public Optional<Booking> findByBookingId(Integer bookingId) {

		if (!repo.existsById(bookingId)) {
			throw new BookingNotFoundException(
					environment.getProperty("booking.invalid.notfound"));
		}

		return repo.findById(bookingId);
	}

	@Override
	public List<Booking> findAllBookings() {

		return (List<Booking>) repo.findAll();
	}
	
	@Override
	public List<Booking> findBookingsByCustomerId(Integer customerId) {

	    return repo.findByCustomerId(customerId);

	}

}