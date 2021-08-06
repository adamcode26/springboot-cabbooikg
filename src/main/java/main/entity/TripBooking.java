package main.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TripBooking {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tripId;
	
	@OneToOne//(cascade = CascadeType.ALL)
	//@JoinColumn(name = "customerId", referencedColumnName = "customerid")
	private Customer customer;
	
	@ManyToOne
	private Driver driver;
	
	private String fromLocation;
	
	private String toLocation;
	
	 @JsonFormat(pattern="DD-MM-YYYY")
	private Date fromDate;
	
	 @JsonFormat(pattern="DD-MM-YYYY")
	private Date toDate;
	
	private boolean status;
	
	private float distanceKm;
	
	private float bill;
	
	public TripBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public float getDistanceKm() {
		return distanceKm;
	}

	public void setDistanceKm(float distanceKm) {
		this.distanceKm = distanceKm;
	}

	public float getBill() {
		return bill;
	}

	public void setBill(float bill) {
		this.bill = bill;
	}

	public TripBooking(int tripId, Customer customer, Driver driver, String fromLocation, String toLocation,
			Date fromDate, Date toDate, boolean status, float distanceKm, float bill) {
		super();
		this.tripId = tripId;
		this.customer = customer;
		this.driver = driver;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.status = status;
		this.distanceKm = distanceKm;
		this.bill = bill;
	}
	
	
}
