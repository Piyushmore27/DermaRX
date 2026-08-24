package com.mfwp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.google.gson.Gson;
import com.mfwp.entity.ApiResponse;
import com.mfwp.entity.User;
import com.mfwp.service.UserService;


/**
 * Servlet implementation class RegisterServlet
 */
//@WebServlet("/RegisterServlet")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
        
    
    private static int createUser(User user) {
    	
    	UserService userService = new UserService();
    	
    	return userService.saveUser(user);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/plain");
		response.getWriter().write("Post for registration");        
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
		
		User user = new User();
		user.setEmail(request.getParameter("username"));
		user.setMobileNumber(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		
		
		int rowsUpdate = RegisterServlet.createUser(user);
	
		ApiResponse<User> userAPI;
		if(rowsUpdate == 1) {
			
			userAPI = new ApiResponse<>(
					true, "User registered successfully", user);
			
			System.out.println("User Registered");
			
//			System.out.println("User registered successfully");
//			response.setContentType("text/html");
//			response.getWriter().print("<html><head></head><body><h1>User registered successfully</h1></body></html>");
//			response.getWriter().print("User registered successfully");
			
		}else if(rowsUpdate == -1) {
			
			userAPI = new ApiResponse<>(
					false, "Improper Username!!!", user);
			
			System.out.println("Improper Username!!!");
		
		}else {
			
			userAPI = new ApiResponse<>(
					false, "User registration Unsuccessfull", user);
			
			System.out.println("Not successfull");
//			System.out.println("Sorry!!! User couldn't be registered");
//			response.getWriter().print("Sorry!!! User couldn't be registered");
//			response.setContentType("text/html");
//			response.getWriter().print("<html><head></head><body><h1>Sorry!!! User couldn't be registered</h1></body></html>");
		}
		
		
		String json = gson.toJson(userAPI);
		
		response.setContentType("application/json");
		response.getWriter().write(json);
		
	}

}
