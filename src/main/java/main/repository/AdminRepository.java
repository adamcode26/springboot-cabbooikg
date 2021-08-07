package main.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import main.entity.Admin;
import main.entity.Customer;
import main.entity.TripBooking;

@Repository
public interface AdminRepository extends JpaRepository <Admin, Integer> {
	
	@Query("SELECT t FROM TripBooking t WHERE t.customer.cusId = :customerId")
	List<TripBooking> getAllTrips(@Param("customerId") Integer customerId);
	
	@Query("SELECT t FROM TripBooking t ORDER BY t.fromDate ASC")
	List<TripBooking> getTripDatewise();
	
	@Query("SELECT t FROM TripBooking t WHERE t.customer.cusId = :customerId AND t.fromDate >= :fromDate AND t.toDate <= :toDate")
	List<TripBooking> getAllTripsForDays(@Param("customerId") int customerId, 
			@Param("fromDate") Date fromDate, @Param("toDate") Date toDate );
	
	@Query("SELECT a FROM Admin a WHERE LOWER(a.username)=LOWER(:username) AND a.password = :password ")
    Admin validateAdmin(@Param("username") String username, @Param("password") String password);
}
