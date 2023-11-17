package com.orderapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.orderapp.bo.UserAddressResp;
import com.orderapp.bo.UserResponse;
import com.orderapp.model.Address;
import com.orderapp.model.User;
import com.orderapp.repository.AddressRepo;
import com.orderapp.repository.UserRepo;
import com.orderapp.service.UserService;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private AddressRepo addressRepo;
	
	@GetMapping("/findAll")
	 public List<User> getAllUsers(){
	        return userRepo.findAll();
	 }
	public User getUserUp(Long userId) {
		return userRepo.findById(userId).orElse(null);
	}
	
   public UserResponse createUser(User userReq){
		UserResponse response = new UserResponse();	
		List<UserAddressResp> addressRespList = new ArrayList<UserAddressResp>();
		UserAddressResp addressResp = null;
   	List<User> user = userRepo.findByEmailId(userReq.getEmailId());
		if(user!=null && user.size()>0) 
			userReq.setUserId(user.get(0).getUserId());
			userRepo.save(userReq);
			user = userRepo.findByEmailId(userReq.getEmailId());
			
			response.setUserId(user.get(0).getUserId());
			response.setUserName(user.get(0).getUserName());
			response.setEmailId(user.get(0).getEmailId());
			for(Address address :user.get(0).getAddress()) {
				addressResp = new UserAddressResp();
				addressResp.setAddressId(address.getAddressId());
				addressResp.setUserName(address.getUserName());
				addressResp.setUserAddress(address.getUserAddress());
				addressResp.setCity(address.getCity());
				addressResp.setState(address.getState());
				addressResp.setPincode(address.getPincode());
				addressResp.setContactNumber(address.getContactNumber());
				addressRespList.add(addressResp);
			}
			response.setAddresses(addressRespList);
		
		
     	
       return response;
   }
	
	
   public Address createAddress(@RequestBody Address address){
   	//User user = userRepo.findById(userReq.getUserId()).orElse(null);
     	
       return addressRepo.save(address);
   }
	
	
   public UserResponse getUser(Long userId){
		UserResponse response = new UserResponse();
		List<UserAddressResp> addressList = new ArrayList<UserAddressResp>();
		User user = userRepo.findById(userId).orElse(null);
		List<Address> addresses = null;
		UserAddressResp adderrResp = null;
		if(user!=null) {
		 addresses = user.getAddress();
		 response.setUserId(user.getUserId());
		 response.setUserName(user.getUserName());
		 response.setEmailId(user.getUserName());
		 if(addresses!=null && addresses.size()>0) {
			 for(Address addre : addresses) {
				 adderrResp = new UserAddressResp();
				 System.out.println("addre.getAddressId()"+addre.getAddressId());
				 adderrResp.setAddressId(addre.getAddressId());
				 adderrResp.setUserName(addre.getUserName());
				 adderrResp.setUserAddress(addre.getUserAddress());
				 adderrResp.setState(addre.getState());
				 adderrResp.setCity(addre.getCity());
				 adderrResp.setPincode(addre.getPincode());
				 adderrResp.setContactNumber(addre.getContactNumber());
				 addressList.add(adderrResp);
			 }
			 response.setAddresses(addressList);
		 }
		 
		}
		return response;
   }
   
   public UserResponse getUserByEmailId(String emailId){
		UserResponse response = new UserResponse();
		List<UserAddressResp> addressList = new ArrayList<UserAddressResp>();
		List<User> users = userRepo.findByEmailId(emailId);
		List<Address> addresses = null;
		UserAddressResp adderrResp = null;
		if(users!=null && users.size()>0) {
		User user = users.get(0);	
		 addresses = user.getAddress();
		 response.setUserId(user.getUserId());
		 response.setUserName(user.getUserName());
		 response.setEmailId(user.getUserName());
		 if(addresses!=null && addresses.size()>0) {
			 for(Address addre : addresses) {
				 adderrResp = new UserAddressResp();
				 adderrResp.setAddressId(addre.getAddressId());
				 adderrResp.setUserName(addre.getUserName());
				 adderrResp.setUserAddress(addre.getUserAddress());
				 adderrResp.setState(addre.getState());
				 adderrResp.setCity(addre.getCity());
				 adderrResp.setPincode(addre.getPincode());
				 adderrResp.setContactNumber(addre.getContactNumber());
				 addressList.add(adderrResp);
			 }
			 response.setAddresses(addressList);
		 }
		 
		}
		return response;
  }
   
   public List<Address> getUserAllAddress(Long userId){
		
		List<Address> addressList = null;
		User user = userRepo.findById(userId).orElse(null);
		
		if(user!=null) {
			addressList = user.getAddress();
			 
		}
		return addressList;
  }
}
