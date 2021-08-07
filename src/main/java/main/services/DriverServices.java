package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.entity.Admin;
import main.entity.Driver;
import main.repository.DriverRepository;

@Service
public class DriverServices {
	
	@Autowired
	private DriverRepository driverRepo;
	
	public void insertDriver(Driver driver) {
		driverRepo.save(driver);
	}
	
	public void updateDriver(Driver driver) {
		driverRepo.save(driver);
	}
	
	public void deleteDriver(Integer id) {
		driverRepo.deleteById(id);
	}
	
	public List<Driver> viewBestDriver(){
        return driverRepo.viewBestDriver();
    }
	
	public Driver viewDriver(Integer id) {
		return driverRepo.findById(id).get();
	}
	
	public List<Driver> viewFreeDriver(){
		return driverRepo.viewFreeDriver();
	}
	
	public Driver validateDriver(String username, String password) {
		return driverRepo.validateDriver(username, password);
	}


}
