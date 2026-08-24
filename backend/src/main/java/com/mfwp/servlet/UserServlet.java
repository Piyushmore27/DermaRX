package com.mfwp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;
import com.mfwp.entity.ApiResponse;
import com.mfwp.entity.User;
import com.mfwp.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    private static int createUser(User user) {
    	
    	UserService userService = new UserService();
    	
    	return userService.saveUser(user);
    }
    
    
    private static boolean checkUser(User user) {
    	
    	UserService userService = new UserService();
    	
    	if(userService.isValidUser(user)) {
    		
    		return true;
    	
    	}
    
    	return false;
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		response.getWriter().write("Post for registration"); 
	}
	
	
	 private class RequestHandler{
     	String username = "";
     	String password = "";
     	String action = "";
     }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        
        
	
        Gson gson = new Gson(); // Needed for react
		
		RequestHandler identifyAction = gson.fromJson(request.getReader(), RequestHandler.class);
		
		ApiResponse<User> userAPI;
		
		if(identifyAction.action.equals("register")) {
			
			User user = new User();
			
			user.setUsername(identifyAction.username);
			user.setPassword(identifyAction.password);
			
			int rowsUpdate = UserServlet.createUser(user);
			
			if(rowsUpdate == 1) {
				
				userAPI = new ApiResponse<>(
						true, "User registered successfully", user);
				
				System.out.println("User Registered");
				
//				System.out.println("User registered successfully");
//				response.setContentType("text/html");
//				response.getWriter().print("<html><head></head><body><h1>User registered successfully</h1></body></html>");
//				response.getWriter().print("User registered successfully");
				
			}else if(rowsUpdate == -1) {
				
				userAPI = new ApiResponse<>(
						false, "User Already Exists!!!", user);
						
			}else {
				System.out.println(rowsUpdate);
				userAPI = new ApiResponse<>(
						false, "User registration Unsuccessfull!!!", user);
				
				System.out.println("Not successfull");
//				System.out.println("Sorry!!! User couldn't be registered");
//				response.getWriter().print("Sorry!!! User couldn't be registered");
//				response.setContentType("text/html");
//				response.getWriter().print("<html><head></head><body><h1>Sorry!!! User couldn't be registered</h1></body></html>");
			}
			
		}else if(identifyAction.action.equals("login")) {
			
			User user = new User();
			
			user.setUsername(identifyAction.username);
			user.setPassword(identifyAction.password);
			
			if(UserServlet.checkUser(user)) {
				
				userAPI = new ApiResponse<>(
						true, "User Login Successfull!!!", user);
				
				System.out.println("Every thing alright");
//				System.out.println("User login successfully");
//				response.setContentType("text/html");
//				response.getWriter().print("<html><head></head><body><h1>User login successfully</h1></body></html>");
			}
			else {
				System.out.println("Not quite right");
				
				userAPI = new ApiResponse<>(
						false, "Login Failed!!!", user);
				
				System.out.println("Invalid Credentails");
				
//				response.setContentType("text/html");
//				response.getWriter().print("<html><head></head><body><h1>Invalid Credentails</h1></body></html>");
			}

			
		
		}else {
			User user = new User();
			
			userAPI = new ApiResponse<>(
					false, "Unidentified Action!!!", user);
		}
		
		
		String json = gson.toJson(userAPI);
		
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
	 */
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
	    response.setHeader("Access-Control-Allow-Headers", "Content-Type");
	    response.setHeader("Access-Control-Allow-Credentials", "true");

	    response.setStatus(HttpServletResponse.SC_OK);
	}

}
