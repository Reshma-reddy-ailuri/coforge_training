package com.coforge.ars.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_waiting_list")
public class WaitingList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer waitingId;

	@NotNull(message = "Booking Id is mandatory")
	private Integer bookingId;

	@NotNull(message = "Waiting Position is mandatory")
	@Min(value = 1, message = "Waiting Position should be greater than 0")
	private Integer waitingPosition;

	@NotBlank(message = "Waiting Status is mandatory")
	private String waitingStatus;

	public WaitingList() {
		super();
	}
	public Integer getWaitingId() {
		return waitingId;
	}

	public void setWaitingId(Integer waitingId) {
		this.waitingId = waitingId;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getWaitingPosition() {
		return waitingPosition;
	}

	public void setWaitingPosition(Integer waitingPosition) {
		this.waitingPosition = waitingPosition;
	}

	public String getWaitingStatus() {
		return waitingStatus;
	}

	public void setWaitingStatus(String waitingStatus) {
		this.waitingStatus = waitingStatus;
	}

	@Override
	public String toString() {
		return "WaitingList [waitingId=" + waitingId + ", bookingId=" + bookingId + ", waitingPosition="
				+ waitingPosition + ", waitingStatus=" + waitingStatus + "]";
	}

}