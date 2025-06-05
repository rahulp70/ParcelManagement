package com.tcs.bookings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.bookings.model.Bookings;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Integer>{
	
	public List<Bookings> findBySenderName(String senderName);
	
	public Bookings findByTrackingId(String trackingId);
	
//	public Bookings findByBookingId(int bookingId);
	


}
