package main.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.entity.Admin;
import main.entity.TripBooking;
import main.repository.AdminRepository;

@Service
public class AdminServices {
	
	@Autowired
	private AdminRepository adminRepo;
	
	public void insertAdmin(Admin admin) {
		adminRepo.save(admin);
	}
	
	public void updateAdmin(Admin admin) {
		adminRepo.save(admin);
	}
	
	public void deleteAdmin(Integer id) {
		adminRepo.deleteById(id);
	}
	
	public List<TripBooking> getAllTrips(Integer id){
		
		List<TripBooking> trips=adminRepo.getAllTrips(id);
		if(trips.isEmpty()) {
			return null;
		}
		return trips;
	}
	
	public List<TripBooking> getTripsDatewise(){
		List<TripBooking> trips= adminRepo.getTripDatewise();
		return trips;
	}
	
	public List<TripBooking> getAllTripsForDays(Integer id, Date fromDate, Date toDate){
		List<TripBooking> trips= adminRepo.getAllTripsForDays(id, fromDate, toDate);
		return trips;
	}
	
	
}
