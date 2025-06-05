package com.tcs.bookings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.bookings.model.Bookings;
import com.tcs.bookings.repository.BookingsRepository;
import com.tcs.bookings.service.BookingsService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookingsController {
	
	@Autowired
	BookingsService bookingsService;
	
	@Autowired
	BookingsRepository bookingsRepository;
	
	@GetMapping("/Hello")
	public String getHello() {
		return "Hello Booking";
	}
	
//  Find bookings by trackingId
	@GetMapping("/trackbooking")
	public Bookings getByTrackId(@RequestParam("trackingId") String trackingId) {
		return this.bookingsRepository.findByTrackingId(trackingId);
	}
	
//	Register
	@PostMapping("/registerbooking")
	public Bookings saveBookings(@RequestBody Bookings bookings) {
		this.bookingsService.save(bookings);
		return bookings;
		
	}
	
//	Find bookings by sender Name (user Name)
	@GetMapping("/bookings/{senderName}")
	public List<Bookings> getBooking(@PathVariable("senderName") String senderName) {
		return this.bookingsService.findUserById(senderName);
	}

//	Delete booking by sender Name (User Name) and booking Id
	@PostMapping("/deletebooking")
	public void deleteBookingByNameAndId(@RequestParam("senderName") String senderName,@RequestParam("bookingId") int bookingId) {
		this.bookingsService.deleteByBookingId(senderName, bookingId);
	}
	
//	Delete all bookings by sender Name (User Name)
	@PostMapping("/deleteallbookings")
	public void deleteAllBookingsByName(@RequestParam("senderName") String senderName) {
		this.bookingsService.deleteAllByName(senderName);
	}
	
//	status Update Booking
	@PostMapping("/updatebooking")
	public void updateBooking(@RequestParam("trackingId") String trackingId,@RequestParam("setstatus") String setstatus) {
		this.bookingsService.update(trackingId,setstatus);
	}
	
//	Pickup drop Update Booking
	@PostMapping("/pdupdatebooking")
	public void pdUpdateBooking(@RequestParam("trackingId") String trackingId,@RequestParam("pickuptime") String pickuptime,@RequestParam("dropofftime") String dropofftime) {
		this.bookingsService.pdUpdate(trackingId,pickuptime,dropofftime);
	}
	
	 @GetMapping("/allbookings")
	    public List<Bookings> getAllBookings() {
	        return bookingsRepository.findAll();
	    }
	 /*@PostMapping("/updateStatus")
	    public ResponseEntity<?> updateStatus(@RequestParam("bookingId") int bookingId, 
	                                        @RequestParam("status") String status) {
	        try {
	            Bookings booking = bookingsRepository.findById(bookingId)
	                .orElseThrow(() -> new RuntimeException("Booking not found"));
	            
	            // Prevent updating if already delivered
	            if ("delivered".equalsIgnoreCase(booking.getStatus())) {
	                return ResponseEntity.badRequest().body("Cannot update status of a delivered package");
	            }
	            
	            booking.setStatus(status);
	            bookingsRepository.save(booking);
	            return ResponseEntity.ok().build();
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }*/
	 @PostMapping("/updateStatus")
	 public ResponseEntity<?> updateStatus(@RequestParam("trackingId") String trackingId, 
	                                       @RequestParam("status") String status) {
	     try {
	         Bookings booking = bookingsRepository.findByTrackingId(trackingId);

	         if (booking == null) {
	             return ResponseEntity.badRequest().body("Booking not found with tracking ID: " + trackingId);
	         }

	         // Prevent updating if already delivered
	         if ("delivered".equalsIgnoreCase(booking.getStatus())) {
	             return ResponseEntity.badRequest().body("Cannot update status of a delivered package");
	         }

	         booking.setStatus(status);
	         bookingsRepository.save(booking);

	         return ResponseEntity.ok().build();

	     } catch (Exception e) {
	         return ResponseEntity.badRequest().body(e.getMessage());
	     }
	 }

}
