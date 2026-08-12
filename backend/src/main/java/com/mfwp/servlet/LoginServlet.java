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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
		
		User user=new User();
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("username"));
		user.setMobileNumber(request.getParameter("username"));
		
//		String email=request.getParameter("email");
//		String mobileNumber=request.getParameter("mobileNumber");
//		String password=request.getParameter("password");
//		String userType=request.getParameter("userType");
		
		Gson gson = new Gson(); // Needed for react
		
		if(LoginServlet.checkUser(user)) {
			
			ApiResponse<User> userAPI = new ApiResponse<>(
					true, "User Login Successfull", user);
			
			String json = gson.toJson(userAPI);
			
			response.setContentType("application/json");
			response.getWriter().write(json);
			
//			System.out.println("User login successfully");
//			response.setContentType("text/html");
//			response.getWriter().print("<html><head></head><body><h1>User login successfully</h1></body></html>");
		}
		else {
			
			ApiResponse<User> userAPI = new ApiResponse<>(
					false, "Login Failed", user);
			
			String json = gson.toJson(userAPI);
			
			response.setContentType("application/json");
			response.getWriter().write(json);
//			System.out.println("Invalid Credentails");
//			response.setContentType("text/html");
//			response.getWriter().print("<html><head></head><body><h1>Invalid Credentails</h1></body></html>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
