 package com.tcs.users.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.users.model.Bookings;
import com.tcs.users.model.Users;
import com.tcs.users.service.UsersService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	@GetMapping("/Hello")
	public String getHello() {
		return "Hello User";
	}
	
//	UserRegister(Create)
	@PostMapping("/register")
	public Users saveUser(@RequestBody Users users) {
//		Logger logger = LoggerFactory.getLogger(getClass());
////		this.usersService.save(users);
//		logger.info("********************************************");
//		logger.info(users.getName());
//		logger.info("********************************************");
		this.usersService.save(users);
		return users;	
	}
	
//	View User Details(Read)
	@GetMapping("/viewuser")
	public Users getUser(@RequestParam("userId") String userId) {
		return this.usersService.getUserByUserId(userId);
	}
	
//	UserLogin
	@GetMapping("/login")
	public ResponseEntity<Map<String, Object>> loginUser(
	    @RequestParam("userId") String userId,
	    @RequestParam("password") String password) {
	    
	    boolean isValid = usersService.verifyPassword(userId, password);
	    Map<String, Object> response = new HashMap<>();
	    
	    if (isValid) {
	        Users user = usersService.getUserByUserId(userId);
	        response.put("success", true);
	        response.put("user", user); // Return user details
	        return ResponseEntity.ok(response);
	    } else {
	        response.put("success", false);
	        response.put("message", "Invalid credentials");
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	    }
	}
	
//	Find all bookings of user by Name
	@GetMapping("/bookingsbyname/{userId}")
	public List<Bookings> getBookingsByUserId(@RequestParam("userId") String userId){
		return usersService.getBookingsByUsersName(userId);
		
	}
	
//	Track booking of user based on booking id (also name)
	@GetMapping("/trackbookingsbybookingId")
	public Bookings getByBookingId(@RequestParam("userId") String userId,@RequestParam("bookingId") int bookingId) {
		return usersService.getByBookingId(userId, bookingId);
	}
	
//	View previous booking of user
	@GetMapping("/previousbooking")
	public Bookings getPrevBooking(@RequestParam("userId") String userId) {
		return usersService.getPreviousBooking(userId);
	}
	
//	Delete user by user id(Delete)
	@PostMapping("/deleteuser")
	public void deleteUserByName(@RequestParam("userId") String userId) {
		this.usersService.deleteUser(userId);
	}
	
//	Update User
	@PostMapping("/updateuser")
	public void updateUser(@RequestBody Users users) {
		this.usersService.update(users);
	}

}
