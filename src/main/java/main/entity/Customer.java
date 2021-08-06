package main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer extends AbstractUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cusId;
	
	@JsonIgnore
	@OneToOne(mappedBy = "customer")
	private TripBooking tripBooking;

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public TripBooking getTripBooking() {
		return tripBooking;
	}

	public void setTripBooking(TripBooking tripBooking) {
		this.tripBooking = tripBooking;
	}

	public Customer(String username, String password, String address, String email, String mobileNumber, int cusId,
			TripBooking tripBooking) {
		super(username, password, address, email, mobileNumber);
		this.cusId = cusId;
		this.tripBooking = tripBooking;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
