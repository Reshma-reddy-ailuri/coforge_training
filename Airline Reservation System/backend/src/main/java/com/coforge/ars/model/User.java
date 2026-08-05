package com.coforge.ars.model;

import java.sql.Timestamp;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tbl_users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@NotBlank(message = "Full Name is mandatory")
	private String fullName;

	@Email(message = "Enter a valid email")
	@NotBlank(message = "Email is mandatory")
	private String email;

	@NotBlank(message = "Password is mandatory")
	@Size(min = 6, message = "Password must contain at least 6 characters")
	private String password;

	@NotBlank(message = "Phone Number is mandatory")
	@Pattern(regexp = "^[0-9]{10}$", message = "Phone Number must contain exactly 10 digits")
	private String phoneNumber;
	
	@NotBlank(message = "Role is mandatory")
	@Pattern(
	    regexp = "ADMIN|CUSTOMER",
	    message = "Role must be either ADMIN or CUSTOMER"
	)
	private String role;

	private boolean isActive;

	private Timestamp createdAt;

	private Timestamp updatedAt;

	public User() {
		super();
	}


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
	    return "User [userId=" + userId +
	            ", fullName=" + fullName +
	            ", email=" + email +
	            ", phoneNumber=" + phoneNumber +
	            ", role=" + role +
	            ", isActive=" + isActive +
	            ", createdAt=" + createdAt +
	            ", updatedAt=" + updatedAt + "]";
	}
}