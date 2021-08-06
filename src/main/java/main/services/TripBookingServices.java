package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.entity.TripBooking;
import main.repository.TripBookingRepository;

@Service
public class TripBookingServices {
	
	@Autowired
	private TripBookingRepository tripBookingRepo;
	
	public void insertTrip(TripBooking trip) {
		tripBookingRepo.save(trip);
		System.out.println(trip.getBill());
	}
	
	public void updateTrip(TripBooking trip) {
		tripBookingRepo.save(trip);
	}
	
	public void deleteTrip(Integer id) {
		tripBookingRepo.deleteById(id);
	}
	
	public List<TripBooking> viewAllTrips(){
		List<TripBooking> trips = tripBookingRepo.findAll();
		return trips;
	}
	public float calculateBill(Integer id) {
		return tripBookingRepo.findById(id).get().getBill();
	}

}
