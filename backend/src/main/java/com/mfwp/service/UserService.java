package com.mfwp.service;

import java.util.List;

import com.mfwp.entity.User;
import com.mfwp.repository.UserRepository;

public class UserService {

public int  saveUser(User user) {
		
		UserRepository userRepostiory =new UserRepository();
		
		if(null==user.getEmail() && null == user.getMobileNumber()) {
			System.out.println("Please enter email or mobile");
			return 0;
		}
		
		if(null==user.getPassword()) {
			System.out.println("Please enter password");
			return 0;
		}
		
		//Please check if user with email id exists
		if(userRepostiory.checkifEmailExists(user)) {
			System.out.println("Email already exits");
			return 0;
		}
		
		//Please check if user with mobile number exits
		if(userRepostiory.checkifMobileNumberExists(user)) {
			System.out.println("Mobile number already exits");
			return 0;
		}
		
		return userRepostiory.saveUser(user);
	}
	
	
	public boolean isValidUser(User user){
		
		UserRepository userRepostiory =new UserRepository();
		
		if(userRepostiory.isValidUser(user)) {
			System.out.println("Login Successfully");
		}
		else {
			System.out.println("Invalid credentials");
			return false;
		}
		return userRepostiory.isValidUser(user);
		
	}
	public List<User> getAllUsers() {
		UserRepository userrepostiory =new UserRepository();
		return userrepostiory.getAllUsers();
	}
	
}
