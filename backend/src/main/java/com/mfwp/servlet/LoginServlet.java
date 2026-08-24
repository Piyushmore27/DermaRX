package com.mfwp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.mfwp.entity.ApiResponse;
import com.mfwp.entity.User;
import com.mfwp.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
@MultipartConfig
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/plain");
		response.getWriter().write("Post for login");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:5173/login");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Allow-Credentials", "true");
		
        Gson gson = new Gson(); // Needed for react
        
        User user = gson.fromJson(request.getReader(), User.class);

        
//		String email=request.getParameter("email");
//		String mobileNumber=request.getParameter("mobileNumber");
//		String password=request.getParameter("password");
//		String userType=request.getParameter("userType");
		
		
		ApiResponse<User> userAPI = null;
		if(LoginServlet.checkUser(user)) {
			
			userAPI = new ApiResponse<>(
					true, "User Login Successfull", user);
			
			System.out.println("Every thing alright");
//			System.out.println("User login successfully");
//			response.setContentType("text/html");
//			response.getWriter().print("<html><head></head><body><h1>User login successfully</h1></body></html>");
		}
		else {
			System.out.println("Not quite right");
			
			userAPI = new ApiResponse<>(
					false, "Login Failed", user);
			
			System.out.println("Invalid Credentails");
			
//			response.setContentType("text/html");
//			response.getWriter().print("<html><head></head><body><h1>Invalid Credentails</h1></body></html>");
		}
		
		
		String json1 = gson.toJson(userAPI);
		
		response.setContentType("application/json");
		response.getWriter().write(json1);
	}

}
