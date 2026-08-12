package com.mfwp.servlet;

import com.mfwp.entity.User;
import com.mfwp.service.UserService;

public class BasicController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserService service = new UserService();
		User user = new User();
		
		user.setEmail("anshmundra1223@gmail.com");
		user.setMobileNumber("anshmundra1223@gmail.com");
		user.setPassword("aubergine1223");
		
		if(service.saveUser(user) == 1) {
			System.out.println("User added");
		
		}else {
			System.out.println("Nope Check Things");
		}
	}

}
