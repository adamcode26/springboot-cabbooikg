package main.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Driver extends AbstractUser{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driverId;
	
	private String licenceNo;
	
	private float rating;
	
	@OneToOne
	private Cab cab;
	
	@JsonIgnore
	@OneToMany(mappedBy = "driver")
	private List<TripBooking> tripBooking;
	
	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public Driver(String username, String password, String address, String email, String mobileNumber, int driverId,
			String licenceNo, float rating, Cab cab) {
		super(username, password, address, email, mobileNumber);
		this.driverId = driverId;
		this.licenceNo = licenceNo;
		this.rating = rating;
		this.cab = cab;
	}

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
