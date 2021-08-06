package main.controller;

import java.util.Date;
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

import main.entity.Admin;
import main.entity.Customer;
import main.entity.TripBooking;
import main.services.AdminServices;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminServices adminServ;
	
	@PostMapping("/new-admin")
	public void insertAdmin(@RequestBody Admin admin) {
		adminServ.insertAdmin(admin);
	}
	
	@PutMapping("/update")
	public void updateAdmin(@RequestBody Admin admin) {
		adminServ.updateAdmin(admin);
	}
	
	@DeleteMapping("/delete/{adminId}")
	public void deleteAdmin(@PathVariable("adminId") int id ) {
		adminServ.deleteAdmin(id);
	}
	
	@GetMapping("/customer-trip/{customerId}")
	public List<TripBooking> getAllTrips(@PathVariable("customerId") int id){
		return adminServ.getAllTrips(id);
	}
	
	@GetMapping("/datewise-trip")
	public ResponseEntity <List<TripBooking>>  getTripsDatewise(){
		List<TripBooking> trips=adminServ.getTripsDatewise();
		if(trips.isEmpty()) {
			return new ResponseEntity("Sorry No customer available", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List <TripBooking> >(trips, HttpStatus.OK);
	}
	
	@GetMapping("/customer-date/{adminId}")
	public ResponseEntity <List<TripBooking>> getTripsDatewise(@PathVariable("adminId") int id,
			@RequestBody Date fromDate, @RequestBody Date toDate){
		List<TripBooking> trips=adminServ.getAllTripsForDays(id,fromDate,toDate);
		if(trips.isEmpty()) {
			return new ResponseEntity("Sorry No customer available", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List <TripBooking> >(trips, HttpStatus.OK); 
	}
}
