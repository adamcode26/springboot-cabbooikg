package main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import main.entity.Customer;
import main.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
	
	@Query("SELECT d FROM Driver d WHERE d.rating>=4.5")
    List<Driver> viewBestDriver();
	
	@Query("select d from Driver d where d.driverId not in (select t.driver.driverId from TripBooking t where t.status=true)")
	List<Driver> viewFreeDriver();
}
