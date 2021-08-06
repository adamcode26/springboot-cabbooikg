package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.entity.TripBooking;

@Repository
public interface TripBookingRepository extends JpaRepository<TripBooking, Integer> {

}
