package com.coforge.ars.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tbl_airplane")
public class Airplane {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer airplaneId;
	@NotBlank(message="Airplane Name is mandatory")
	private String airplaneName;

	@NotBlank(message="Registration Number is mandatory")
	private String airplaneRegistrationNo;

	@NotBlank(message="Description is mandatory")
	private String airplaneDescription;

	@Min(value=1, message="Total seats must be greater than 0")
	private int totalSeat;

	@Min(value=1, message="Economy seats must be greater than 0")
	private int totalEconomySeat;

	@Min(value=1, message="Business seats must be greater than 0")
	private int totalBusinessSeat;

	@Min(value=1, message="First class seats must be greater than 0")
	private int totalFirstClassSeat;
	public Airplane() {
		super();
	}
	public Integer getAirplaneId() {
	    return airplaneId;
	}
	public void setAirplaneId(Integer airplaneId) {
		this.airplaneId = airplaneId;
	}
	public String getAirplaneName() {
		return airplaneName;
	}
	public void setAirplaneName(String airplaneName) {
		this.airplaneName = airplaneName;
	}
	public String getAirplaneRegistrationNo() {
		return airplaneRegistrationNo;
	}
	public void setAirplaneRegistrationNo(String airplaneRegistrationNo) {
		this.airplaneRegistrationNo = airplaneRegistrationNo;
	}
	public String getAirplaneDescription() {
		return airplaneDescription;
	}
	public void setAirplaneDescription(String airplaneDescription) {
		this.airplaneDescription = airplaneDescription;
	}
	public int getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}
	public int getTotalEconomySeat() {
		return totalEconomySeat;
	}
	public void setTotalEconomySeat(int totalEconomySeat) {
		this.totalEconomySeat = totalEconomySeat;
	}
	public int getTotalBusinessSeat() {
		return totalBusinessSeat;
	}
	public void setTotalBusinessSeat(int totalBusinessSeat) {
		this.totalBusinessSeat = totalBusinessSeat;
	}
	public int getTotalFirstClassSeat() {
		return totalFirstClassSeat;
	}
	public void setTotalFirstClassSeat(int totalFirstClassSeat) {
		this.totalFirstClassSeat = totalFirstClassSeat;
	}
	@Override
	public String toString() {
		return "Airplane [airplaneId=" + airplaneId + ", airplaneName=" + airplaneName + ", airplaneRegistrationNo="
				+ airplaneRegistrationNo + ", airplaneDescription=" + airplaneDescription + ", totalSeat=" + totalSeat
				+ ", totalEconomySeat=" + totalEconomySeat + ", totalBusinessSeat=" + totalBusinessSeat
				+ ", totalFirstClassSeat=" + totalFirstClassSeat + "]";
	}
	
	
	

}
