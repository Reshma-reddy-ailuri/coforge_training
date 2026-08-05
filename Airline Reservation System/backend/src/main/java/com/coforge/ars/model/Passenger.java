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
@Table(name = "tbl_passenger")
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer passengerId;

	@NotNull(message = "Booking Id is mandatory")
	private Integer bookingId;

	@NotBlank(message = "Passenger Name is mandatory")
	private String passengerName;

	@NotNull(message = "Age is mandatory")
	@Min(value = 1, message = "Age should be greater than 0")
	private Integer age;

	@NotBlank(message = "Gender is mandatory")
	private String gender;

	@NotBlank(message = "Seat Number is mandatory")
	private String seatNumber;

	public Passenger() {
		super();
	}


	public Integer getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", bookingId=" + bookingId + ", passengerName="
				+ passengerName + ", age=" + age + ", gender=" + gender + ", seatNumber=" + seatNumber + "]";
	}

}