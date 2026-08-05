package com.coforge.ars.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coforge.ars.model.Booking;
import com.coforge.ars.service.BookingService;

import jakarta.validation.Valid;
import java.io.ByteArrayOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class BookingController {

	private BookingService service;
	private Environment environment;

	@Autowired
	public BookingController(BookingService service, Environment environment) {
		this.service = service;
		this.environment = environment;
	}

	@PostMapping("/bookings")
	public ResponseEntity<String> saveBooking(@Valid @RequestBody Booking booking) {

		service.saveBooking(booking);

		return new ResponseEntity<>(
				environment.getProperty("booking.save.success"),
				HttpStatus.CREATED);
	}

	@PutMapping("/bookings/{bookingId}")
	public ResponseEntity<String> updateBooking(@PathVariable Integer bookingId,
			@Valid @RequestBody Booking booking) {

		service.updateBooking(bookingId, booking);

		return new ResponseEntity<>(
				environment.getProperty("booking.update.success"),
				HttpStatus.OK);
	}

	@DeleteMapping("/bookings/{bookingId}")
	public ResponseEntity<String> deleteBooking(@PathVariable Integer bookingId) {

		service.deleteBookingById(bookingId);

		return new ResponseEntity<>(
				environment.getProperty("booking.delete.success"),
				HttpStatus.OK);
	}

	@GetMapping("/bookings/{bookingId}")
	public ResponseEntity<Booking> findByBookingId(@PathVariable Integer bookingId) {

		Optional<Booking> booking = service.findByBookingId(bookingId);

		return new ResponseEntity<>(
				booking.get(),
				HttpStatus.OK);
	}

	@GetMapping("/bookings")
	public ResponseEntity<List<Booking>> findAllBookings() {

		return new ResponseEntity<>(
				service.findAllBookings(),
				HttpStatus.OK);
	}
	
	@GetMapping("/bookings/customer/{customerId}")
	public ResponseEntity<List<Booking>> findBookingsByCustomerId(
			@PathVariable Integer customerId) {

		return new ResponseEntity<>(
				service.findBookingsByCustomerId(customerId),
				HttpStatus.OK);
	}
	
	@GetMapping("/bookings/{bookingId}/ticket")
	public ResponseEntity<byte[]> downloadTicket(
	        @PathVariable Integer bookingId) {

	    Optional<Booking> bookingOptional = service.findByBookingId(bookingId);

	    if (bookingOptional.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }

	    Booking booking = bookingOptional.get();

	    try {

	        ByteArrayOutputStream out = new ByteArrayOutputStream();

	        Document document = new Document();

	        PdfWriter.getInstance(document, out);

	        document.open();

	        Font title = new Font(Font.HELVETICA, 20, Font.BOLD);

	        Font heading = new Font(Font.HELVETICA, 14, Font.BOLD);

	        Font content = new Font(Font.HELVETICA, 12);

	        document.add(new Paragraph("AIRLINE RESERVATION SYSTEM", title));

	        document.add(new Paragraph(" "));
	        document.add(new Paragraph("E-TICKET", heading));
	        document.add(new Paragraph(" "));

	        document.add(new Paragraph(
	                "Booking ID : " + booking.getBookingId(),
	                content));

	        document.add(new Paragraph(
	                "Customer ID : " + booking.getCustomerId(),
	                content));

	        document.add(new Paragraph(
	                "Flight ID : " + booking.getFlightId(),
	                content));

	        document.add(new Paragraph(
	                "Seat Class : " + booking.getSeatClass(),
	                content));

	        document.add(new Paragraph(
	                "Passengers : " + booking.getPassengerCount(),
	                content));

	        document.add(new Paragraph(
	                "Total Amount : ₹ " + booking.getTotalAmount(),
	                content));

	        document.add(new Paragraph(
	                "Booking Date : " + booking.getBookingDate(),
	                content));

	        document.add(new Paragraph(
	                "Status : " + booking.getBookingStatus(),
	                content));

	        document.add(new Paragraph(" "));
	        document.add(new Paragraph(
	                "Have a Safe Journey ✈",
	                heading));

	        document.close();

	        HttpHeaders headers = new HttpHeaders();

	        headers.setContentType(MediaType.APPLICATION_PDF);

	        headers.setContentDispositionFormData(
	                "attachment",
	                "Ticket_" + booking.getBookingId() + ".pdf");

	        return ResponseEntity.ok()
	                .headers(headers)
	                .body(out.toByteArray());

	    }

	    catch (Exception e) {

	        return ResponseEntity.internalServerError().build();

	    }

	}

}