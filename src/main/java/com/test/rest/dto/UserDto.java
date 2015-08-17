package com.test.rest.dto;

public class UserDto{
	
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	private String email;
	
	private String birthdate;
	
	private String phone;
	
	private String gender;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() { 
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
			return "User: First Name - " + this.firstName + 
					"; Last Name - " + this.lastName + 
					"; Email - " + this.email + 
					"; BirthDate - " + this.birthdate + 
					"; Phone: " + this.phone + 
					"; Gender - " + this.gender +
					"; Password" + this.password;
	}
}
