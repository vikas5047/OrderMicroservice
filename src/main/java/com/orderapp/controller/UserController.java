package com.orderapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.orderapp.bo.UserResponse;
import com.orderapp.model.Address;
import com.orderapp.model.AddressInput;
import com.orderapp.model.User;
import com.orderapp.model.UserInput;

import com.orderapp.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	
	@GetMapping("/findAll")
	 public List<User> getAllUsers(){
	        return userService.getAllUsers();
	 }
	
	@PostMapping("/addUser")
    public UserResponse addUser(@RequestBody User userReq){
    	
		return userService.createUser(userReq);
    }
	
	@MutationMapping("createUser")
    public UserResponse createUser(@Argument UserInput userInput){
		User user = new User();
		user.setUserName(userInput.getUserName());
		
		user.setEmailId(userInput.getEmailId());
		Address address = new Address();
		List<Address> addressList = new ArrayList<Address>();
		
		if(userInput.getAddresses()!=null && userInput.getAddresses().size()>0) {
			
			address.setUserAddress(userInput.getAddresses().get(0).getUserAddress());
			address.setUserName(userInput.getAddresses().get(0).getUserName());
			address.setCity(userInput.getAddresses().get(0).getCity());
			address.setState(userInput.getAddresses().get(0).getState());
			address.setContactNumber(userInput.getAddresses().get(0).getContactNumber());
			address.setPincode(userInput.getAddresses().get(0).getPincode());
			addressList.add(address);
		}
		
		user.setAddress(addressList);
		
		return userService.createUser(user);
    }
	
	@MutationMapping("createAddress") 
    public Address createAddress(@Argument AddressInput addressInput){
    	Address address = new Address();
    	address.setUserName(addressInput.getUserName());
    	address.setUserAddress(addressInput.getUserAddress());
    	address.setState(addressInput.getState());
    	address.setCity(addressInput.getCity());
    	address.setContactNumber(addressInput.getContactNumber());
    	address.setPincode(addressInput.getPincode());
    	User user =userService.getUserUp(addressInput.getUserId());
    	address.setUser(user);
    	
        return userService.createAddress(address);
    }
	
	@QueryMapping("getUser")
    public UserResponse getUser(@Argument Long userId){
		UserResponse response =null;
		response = userService.getUser(userId);
		System.out.println("response"+response.getAddresses().get(0).getAddressId());
		return response;
    }
	

    @QueryMapping("getEmailUser")
    public UserResponse getEmailUser(@Argument String emailId) {
    
    	return userService.getUserByEmailId(emailId);
    
    }
    
    @QueryMapping("getUserAllAddress")
    public List<Address> getUserAllAddress(@Argument Long userId){
    	return userService.getUserAllAddress(userId);
    }
	
}
