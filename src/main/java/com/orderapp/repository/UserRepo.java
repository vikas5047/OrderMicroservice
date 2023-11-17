package com.orderapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderapp.model.User;
import java.util.List;




public interface UserRepo extends JpaRepository<User,Long> {

	List<User> findByEmailId(String emailId);
}
