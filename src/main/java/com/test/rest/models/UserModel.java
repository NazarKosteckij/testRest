package com.test.rest.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Check;


@Table(name="users")
@Entity(name = "userModel")
@Check(constraints="(users.gender = 'male' OR users.gender = 'female')")
public class UserModel {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;

	@Column(name="password")
	private String password;
	
	@Column(name="email", unique=true)
	private String email;
	
	@Column(name="birthdate")
	private Date birthdate;
	
	@Column(name="phone", length=15)
	private String phone;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="role", columnDefinition="varchar(12) default 'user'")
	private String role;
	
	@Column(name="status", columnDefinition="varchar(11) default 'unconfirmed'", nullable = false)
	private String status = "unconfirmed";
	
	@Column(name="confirmationHash")
	private String confirmationHash;

	@OneToMany(mappedBy = "owner")
	private List<DeviceModel> devices;

	public List<DeviceModel> getDevices() {
		return devices;
	}

	public void setDevices(List<DeviceModel> devices) {
		this.devices = devices;
	}


	public UserModel() {

	}

	public String getConfirmationHash() {
		return confirmationHash;
	}

	public void setConfirmationHash(String confirmationHash) {
		this.confirmationHash = confirmationHash;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
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
		
		return "first name: " + this.firstName + ", lastName: " + this.lastName + ", email:" + this.email;
	}
}
