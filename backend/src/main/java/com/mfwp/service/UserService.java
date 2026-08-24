package com.mfwp.service;

import java.util.List;
import java.util.regex.Pattern;

import com.mfwp.entity.User;
import com.mfwp.repository.UserRepository;

public class UserService {
	
	
	private static boolean identifyUsername(User user) {
		
		String query = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		
		
		if(Pattern.matches(query, user.getUsername())) {
			
			user.setEmail(user.getUsername());
			user.setMobileNumber(null);

			return true;
		
		}else {
			
			query = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";
			
			if(Pattern.matches(query, user.getUsername())) {
				
				user.setMobileNumber(user.getUsername());
				user.setEmail(null);

				return true;
			
			}else {
				
				user.setEmail(null);
				user.setMobileNumber(null);
				
				return false;
			}
		}
	}
	
	
	
	//Registration Method
	public int saveUser(User user) {
		
		if(!UserService.identifyUsername(user)) {
			
			return -1; 
		}
		
		
		UserRepository userRepostiory =new UserRepository();
		
		
		if(null == user.getPassword() || user.getPassword().equals("")) {
			
			return 0;
		
		}else if(user.getPassword().length() > 50 || user.getPassword().length() < 8) {
			
			return 0;
		}
		
		
		if(user.getMobileNumber() == null) {
			
			//Please check if user with email id exists
			if(userRepostiory.checkifEmailExists(user)) {
				return -1;
			}
			
		}else {
			
			//Please check if user with mobile number exits
			if(userRepostiory.checkifMobileNumberExists(user)) {
				return -1;
			}
		}
		
		
		return userRepostiory.saveUser(user);
	}
	
	
	//Login Verification
	public boolean isValidUser(User user){
		
		if(!UserService.identifyUsername(user)) {
			
			return false; 
		}
		
		UserRepository userRepostiory = new UserRepository();
		
		if(userRepostiory.isValidUser(user)) {
			
			return true;
		}
		
		return false;
		
	}
	
	
	
	//Admin Method
	public List<User> getAllUsers() {
		UserRepository userrepostiory =new UserRepository();
		return userrepostiory.getAllUsers();
	}
	
}
