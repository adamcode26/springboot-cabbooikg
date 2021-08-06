package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.entity.Cab;
import main.entity.TripBooking;
import main.repository.CabRepository;

@Service
public class CabServices {
	
	@Autowired
	private CabRepository cabRepo;
	
	public void insertCab(Cab cab) {
		cabRepo.save(cab);
	}
	
	public void updateCab(Cab cab) {
		cabRepo.save(cab);
	}
	
	public void deleteCab(Integer id) {
		cabRepo.deleteById(id);
	}
	
	public int countCab(String carType) {
		return cabRepo.countCab(carType);
	}
	
	public List<Cab> viewCab(String carType){
		List<Cab> cars = cabRepo.viewCab(carType);
		return cars;
	}
	
	public List<Cab> viewAllCabs(){
		List<Cab> cabs = cabRepo.findAll();
		return cabs;
	}

}
