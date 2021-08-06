package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import main.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	/*@Query("SELECT c FROM Customer c WHERE LOWER(c.username)=LOWER(:username) AND c.password = :password ")
    Customer validateCustomer(@Param("customer") String username, @Param("password") String password);*/
}

