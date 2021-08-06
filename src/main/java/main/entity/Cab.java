package main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cabId;
	
	private String carType;
	
	private float perKmRate;
	
	@JsonIgnore
	@OneToOne(mappedBy="cab")
	private Driver driver;
	
	public int getCabId() {
		return cabId;
	}

	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public float getPerKmRate() {
		return perKmRate;
	}

	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Cab() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
