package com.tcs.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.users.model.Bookings;
import com.tcs.users.model.Users;
import com.tcs.users.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	BookingService bookingService;
	
//	To save details into database
	public void save(Users users) {
		this.usersRepository.save(users);
	}
	
//	Finding User details based on User Id
	public Users getUserByUserId(String userId) {
		return this.usersRepository.findByUserId(userId);
	}
	
//	For Update
	public void update(Users users) {
		if(getUserByUserId(users.getUserId())==null) {
			return;
		}
		this.usersRepository.save(users);
	}
	
//	For Login
//	To match password After Retreiving user details using findByUserId(userId) method of repository
//	and returning boolean value if sucessfull.
	public boolean verifyPassword(String userId,String password) {
		Users user=this.usersRepository.findByUserId(userId);
		if(password.equals(user.getPassword())) {
			return true;
		}else {
			return false;
		}
	}
	
//	Retrive and return list of bookings by Name of user(Sender Name)
	public List<Bookings> getBookingsByUsersName(String userId){
		Users users=getUserByUserId(userId);
		return bookingService.findUserByName(users.getName());
	}
	
//	For Specific booking of user
//	After Retrieving list from findUserByName(senderName) method of Repository finding user booking 
//	by specific booking Id entered and returning single bookings object
//	if no bookings found written object with setStatus as not found and other values as null
	public Bookings getByBookingId(String userId,int bookingId) {
		Users users=getUserByUserId(userId);
		List<Bookings> bookings=bookingService.findUserByName(users.getName());
		int count=0;
		Bookings b2=new Bookings();
		for (Bookings b1 : bookings) {
			if(bookingId==b1.getBookingId()) {
				b2=b1;
				count++;
			}
		}
		if(count==0) {
			b2.setStatus("Not Found");
			return b2;
		}else {
		return b2;
		}
	}
	
	
//	retrive most recent booking or previous booking based on user name
//	return booking object if found else setStatus no any bookings found and return booking object
	public Bookings getPreviousBooking(String userId) {
		Users users=getUserByUserId(userId);
		List<Bookings> bookings=bookingService.findUserByName(users.getName());
		Bookings booking=new Bookings();
		if(!bookings.isEmpty()) {
			booking=bookings.get(bookings.size()-1);
			return booking;
		}else {
			booking.setStatus("No any Bookings found");
			return booking;
		}
	}
	
//	Delete user by UserId or User Name and firstdelete that users name bookings
	public void deleteUser(String userId) {
		Users u1=this.usersRepository.findByUserId(userId);
		
		String senderName=u1.getName();
		
		List<Bookings> bookings=bookingService.findUserByName(senderName);
		this.bookingService.deleteAllBookingsByName(senderName);
		
		this.usersRepository.delete(u1);
	}
}
