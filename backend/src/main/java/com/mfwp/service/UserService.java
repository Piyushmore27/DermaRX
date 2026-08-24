package com.mfwp.service;

import java.util.List;
import java.util.regex.Pattern;

import com.mfwp.entity.User;
import com.mfwp.repository.UserRepository;

public class UserService {
	
	
	private static boolean identifyUsername(User user) {

	    String username = user.getUsername();

	    if (username == null || username.trim().isEmpty()) {
	        return false;
	    }

	    String query = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

	    // Username is an email
	    if (Pattern.matches(query, username)) {

	        user.setEmail(username);
	        user.setMobileNumber(null);

	        return true;
	    }

	    // Username is a mobile number
	    query = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";

	    if (Pattern.matches(query, username)) {

	        user.setMobileNumber(username);
	        user.setEmail(null);

	        return true;
	    }

	    // Neither email nor mobile
	    user.setEmail(null);
	    user.setMobileNumber(null);

	    return false;
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
				return 0;
			}
			
		}else {
			
			//Please check if user with mobile number exits
			if(userRepostiory.checkifMobileNumberExists(user)) {
				return 0;
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
