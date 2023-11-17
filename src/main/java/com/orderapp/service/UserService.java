package com.orderapp.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.orderapp.bo.UserResponse;
import com.orderapp.model.Address;
import com.orderapp.model.User;

public interface UserService {
	
	public List<User> getAllUsers();
	
	public UserResponse createUser(User userReq);
	
	public Address createAddress(@RequestBody Address address);
	
	 public UserResponse getUser(Long userId);
	 
	 public UserResponse getUserByEmailId(String emailId);
	 
	 public List<Address> getUserAllAddress(Long userId);
	 
	 public User getUserUp(Long userId);

}
