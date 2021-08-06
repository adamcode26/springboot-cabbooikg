package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.entity.Customer;
import main.entity.TripBooking;
import main.services.TripBookingServices;

@CrossOrigin
@RestController
@RequestMapping("/trip")
public class TripBookingController {

	@Autowired
	private TripBookingServices tripServ;
	
	@PostMapping("/new-trip")
	public void newTrip(@RequestBody TripBooking trip) {
		
		tripServ.insertTrip(trip);
	}
	
	@PutMapping("/update")
	public void updateTrip(@RequestBody TripBooking trip) {
		tripServ.updateTrip(trip);
	}
	
	@DeleteMapping("/delete/{tripId}")
	public void deleteTrip(@PathVariable("tripId") Integer tripId) {
		tripServ.deleteTrip(tripId);
	}
	
	@GetMapping("/view")
	public ResponseEntity <List<TripBooking>> viewAllTrip(){
		
		List <TripBooking> trips = tripServ.viewAllTrips();
		
		if(trips.isEmpty()) {
			return new ResponseEntity("Sorry No customer available", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List <TripBooking> >(trips, HttpStatus.OK);
	}
	
	@GetMapping("/bill/{tripId}")
	public float calculateBill(@PathVariable("tripId") Integer tripId) {
		return tripServ.calculateBill(tripId);
	}
}
