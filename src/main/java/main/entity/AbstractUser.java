package main.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractUser {
	
	private String username;
	
	private String password;
	
	private String address;
	
	private String email;
	
	private String mobileNumber;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public AbstractUser(String username, String password, String address, String email, String mobileNumber) {
		super();
		this.username = username;
		this.password = password;
		this.address = address;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	public AbstractUser() {
		super();
		// TODO Auto-generated constructor stub
	}

}
