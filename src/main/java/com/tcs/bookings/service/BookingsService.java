package com.tcs.bookings.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.bookings.model.Bookings;
import com.tcs.bookings.repository.BookingsRepository;

@Service
public class BookingsService {
	
	@Autowired
	BookingsRepository bookingsRepository;
	
//	create
	public void save(Bookings bookings) {
		this.bookingsRepository.save(bookings);
	}
	
	
//	public Bookings getBookingByBookingId(int bookingId) {
//		return this.bookingsRepository.findByBookingId(bookingId);
//	}
	
//	Update
	public void update(String trackingId,String setstatus) {
//		List<Bookings> b1=bookingsRepository.findBySenderName(bookings.getSenderName());
		
		Bookings bmain=bookingsRepository.findByTrackingId(trackingId);
//		Bookings booking=bmain.get();
//		if(!bmain.getStatus().equalsIgnoreCase("Delivered")) {
//		Bookings b3=new Bookings();
//		for(Bookings b2:b1) {
//			if(bookings.getBookingId()==b2.getBookingId()) {
//				b3=b2;
//			}
//		}
		String set=setstatus;
		bmain.setStatus(set);
//		
		this.bookingsRepository.save(bmain);
//		}
//		}else {
//			
//		}
	}
	
	public void pdUpdate(String trackingId,String pickuptime,String dropofftime) {
//		List<Bookings> b1=bookingsRepository.findBySenderName(bookings.getSenderName());
		
		Bookings bmain=bookingsRepository.findByTrackingId(trackingId);
//		Bookings booking=bmain.get();
//		if(!bmain.getStatus().equalsIgnoreCase("Delivered")) {
//		Bookings b3=new Bookings();
//		for(Bookings b2:b1) {
//			if(bookings.getBookingId()==b2.getBookingId()) {
//				b3=b2;
//			}
//		}
		String pickup=pickuptime;
		String dropoff=dropofftime;
		
		bmain.setParcelPickupTime(pickuptime);
		bmain.setParcelDropoffTime(dropofftime);
//		
		this.bookingsRepository.save(bmain);
//		}
//		}else {
//			
//		}
	}
//	
	public List<Bookings> findUserById(String senderName) {
		return this.bookingsRepository.findBySenderName(senderName);
	}
	
//	Delete booking by booking Id And Sender Name
	public void deleteByBookingId(String senderName,int bookingId) {
		List<Bookings> bookings=this.bookingsRepository.findBySenderName(senderName);
		Bookings result=new Bookings();
		for(Bookings b1:bookings) {
			if(bookingId==b1.getBookingId()) {
				result=b1;
			}
		}
		bookingsRepository.delete(result);
	}
	
//	Delete all bookings by sender Name (User Name)
	public void deleteAllByName(String senderName) {
		List<Bookings> bookings=this.bookingsRepository.findBySenderName(senderName);
		bookingsRepository.deleteAll(bookings);
	}	

}
