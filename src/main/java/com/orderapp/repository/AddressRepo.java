package com.orderapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderapp.model.Address;



public interface AddressRepo extends JpaRepository<Address,Long> {
	
	//List<Address> addressList = fi

}
