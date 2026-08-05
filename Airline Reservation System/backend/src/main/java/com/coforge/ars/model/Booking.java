package com.coforge.ars.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;

	@NotNull(message = "Customer Id is mandatory")
	private Integer customerId;

	@NotNull(message = "Flight Id is mandatory")
	private Integer flightId;

	@NotBlank(message = "Seat Class is mandatory")
	private String seatClass;

	@NotNull(message = "Passenger Count is mandatory")
	@Min(value = 1, message = "Passenger Count should be greater than 0")
	private Integer passengerCount;

	@NotNull(message = "Total Amount is mandatory")
	private BigDecimal totalAmount;

	private Timestamp bookingDate;

	@NotBlank(message = "Booking Status is mandatory")
	private String bookingStatus;

	public Booking() {
		super();
	}

	public Booking(Integer bookingId, Integer customerId, Integer flightId, String seatClass,
			Integer passengerCount, BigDecimal totalAmount, Timestamp bookingDate,
			String bookingStatus) {
		super();
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.flightId = flightId;
		this.seatClass = seatClass;
		this.passengerCount = passengerCount;
		this.totalAmount = totalAmount;
		this.bookingDate = bookingDate;
		this.bookingStatus = bookingStatus;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	public Integer getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(Integer passengerCount) {
		this.passengerCount = passengerCount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Timestamp getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Timestamp bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", customerId=" + customerId + ", flightId=" + flightId
				+ ", seatClass=" + seatClass + ", passengerCount=" + passengerCount
				+ ", totalAmount=" + totalAmount + ", bookingDate=" + bookingDate
				+ ", bookingStatus=" + bookingStatus + "]";
	}
}