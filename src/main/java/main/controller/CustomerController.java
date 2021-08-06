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
import main.services.CustomerServices;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerServices customerServ;
	
	@GetMapping("/view")
	public ResponseEntity <List<Customer>> viewCustomerList(){
		
		List <Customer> customers = customerServ.viewAllCustomer();
		
		if(customers.isEmpty()) {
			return new ResponseEntity("Sorry No customer available", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List <Customer> >(customers, HttpStatus.OK);
	}
	
	@PostMapping("/new-customer")
	public void insertCustomer(@RequestBody Customer newCustomer ) {
		customerServ.insertCustomer(newCustomer);
	}
	
	@DeleteMapping("/delete/{customerId}")
	public void deleteCustomer(@PathVariable("customerId") int customerId) {
		customerServ.deleteCustomer(customerId);
	}
	
	@PutMapping("/update")
	public void updateCustomer(@RequestBody Customer customer) {
		customerServ.updateCustomer(customer);
	}
	
	@GetMapping("/view/{customerId}")
	public Customer viewCustomer(@PathVariable("customerId") int customerId) {
		return customerServ.viewCustomer(customerId);
	}
	
	 @PostMapping("/validate")
	    public ResponseEntity<Customer> validateUser(@RequestBody Customer customer){
	                String user=customer.getUsername();
	                String pass = customer.getPassword();
	                Customer valid = customerServ.validateCustomer(user,pass);
	                if(valid!=null){
	                    return new ResponseEntity(valid, HttpStatus.ACCEPTED);
	                }

	                return new ResponseEntity("Sorry No customer available", HttpStatus.NOT_FOUND);
	    }
	
}
