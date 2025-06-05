package com.tcs.bookings.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "Users",url = "http://localhost:8082")
public interface UsersService {

}
