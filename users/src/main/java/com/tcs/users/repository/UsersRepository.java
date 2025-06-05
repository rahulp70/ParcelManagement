package com.tcs.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.users.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String>{
	public Users findByUserId(String userId);
	
//	public Users findByUserName(String userName);

}
