package com.mfwp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.mfwp.entity.User;
import com.mfwp.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
//@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		User user=new User();
		user.setPassword(request.getParameter("password"));
		user.setMobileNumber(request.getParameter("mobileNumber"));
		user.setEmail(request.getParameter("email"));
		user.setUserType(request.getParameter("userType"));
		
		UserService userService = new UserService();
		int rowsUpdated = userService.saveUser(user);

		if(rowsUpdated ==1) {
			System.out.println("User registered successfully");
			response.setContentType("text/html");
			response.getWriter().print("<html><head></head><body><h1>User registered successfully</h1></body></html>");
//			response.getWriter().print("User registered successfully");
		}else {
			System.out.println("Sorry!!! User couldn't be registered");
//			response.getWriter().print("Sorry!!! User couldn't be registered");
			response.setContentType("text/html");
			response.getWriter().print("<html><head></head><body><h1>Sorry!!! User couldn't be registered</h1></body></html>");
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
