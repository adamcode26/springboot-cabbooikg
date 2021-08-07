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

import main.entity.Admin;
import main.entity.Customer;
import main.entity.Driver;
import main.services.DriverServices;

@CrossOrigin
@RestController
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	private DriverServices driverServ;
	
	@PostMapping("/new-driver")
	public void insertDriver(@RequestBody Driver driver) {
		driverServ.insertDriver(driver);
		
	}
	
	@PutMapping("/update")
	public void updateDriver(@RequestBody Driver driver) {
		driverServ.updateDriver(driver);
	}
	
	@DeleteMapping("/delete/{driverId}")
	public void deleteCustomer(@PathVariable("driverId") int driverId) {
		driverServ.deleteDriver(driverId);
	}
	
	@GetMapping("/view/{driverId}")
	public Driver viewDriver(@PathVariable("driverId") int driverId) {
		return driverServ.viewDriver(driverId);
	}
	
	@GetMapping("/getbestdriver")
    public ResponseEntity<List<Driver>> viewBestDrivers(){
        List<Driver> driver=driverServ.viewBestDriver();
        if(driver.isEmpty()){
            return new ResponseEntity("sorry No driver found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(driver,HttpStatus.OK);
    }
	
	@GetMapping("/getfreedriver")
    public ResponseEntity<List<Driver>> viewFreetDrivers(){
        List<Driver> driver=driverServ.viewFreeDriver();
        if(driver.isEmpty()){
            return new ResponseEntity("sorry No driver found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(driver,HttpStatus.OK);
    }
	
	@PostMapping("/validate")
    public ResponseEntity<Driver> validateUser(@RequestBody Driver driver){
                String user=driver.getUsername();
                String pass = driver.getPassword();
                Driver valid = driverServ.validateDriver(user,pass);
                if(valid!=null){
                    return new ResponseEntity(valid, HttpStatus.ACCEPTED);
                }

                return new ResponseEntity("Sorry No customer available", HttpStatus.NOT_FOUND);
    }
}
