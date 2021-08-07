package main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import main.entity.Admin;
import main.entity.Customer;
import main.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
	
	@Query("SELECT d FROM Driver d WHERE d.rating>=4.5")
    List<Driver> viewBestDriver();
	
	@Query("select d from Driver d where d.driverId not in (select t.driver.driverId from TripBooking t where t.status=true)")
	List<Driver> viewFreeDriver();
	
	@Query("SELECT d FROM Driver d WHERE LOWER(d.username)=LOWER(:username) AND d.password = :password ")
    Driver validateDriver(@Param("username") String username, @Param("password") String password);
}
