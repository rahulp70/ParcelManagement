package com.tcs.users.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.users.model.Bookings;

@FeignClient(name ="bookings", url="http://localhost:8081")
public interface BookingService {
	
	@GetMapping("/bookings/{senderName}")
	public List<Bookings> findUserByName(@PathVariable("senderName") String senderName);
	
	@PostMapping("/deleteallbookings")
	public void deleteAllBookingsByName(@RequestParam("senderName") String senderName);

}
