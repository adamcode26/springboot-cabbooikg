package main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.entity.Customer;
import main.repository.CustomerRepository;

@Service
public class CustomerServices {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	
	/*public CustomerRepository getCustomerRepo() {
		return customerRepo;
	}

	public void setCustomerRepo(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}*/

	public void insertCustomer(Customer customer) {
		customerRepo.save(customer);
	}
	
	public Customer viewCustomer(Integer id) {
		return customerRepo.findById(id).get();
	}
	
	public void updateCustomer(Customer customer) {
		customerRepo.save(customer);
	}
	
	public void deleteCustomer(Integer id) {
		customerRepo.deleteById(id);
	}
	
	public List<Customer> viewAllCustomer(){
		return customerRepo.findAll();
	}
	
	public Customer validateCustomer(String username,String password){
        Customer customer = customerRepo.validateCustomer(username,password);
        if(customer!=null)
            return customer;
//            customerRepository.findAll();
        System.out.println("Wrong UserName Or Password");
        return null;
    }
}
