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
		
//		String email=request.getParameter("email");
//		String mobileNumber=request.getParameter("mobileNumber");
//		String password=request.getParameter("password");
//		String userType=request.getParameter("userType");
		
		UserService userService = new UserService();
		if(userService.isValidUser(user)) {
			System.out.println("User login successfully");
			response.setContentType("text/html");
			response.getWriter().print("<html><head></head><body><h1>User login successfully</h1></body></html>");
		}
		else {
			System.out.println("Invalid Credentails");
			response.setContentType("text/html");
			response.getWriter().print("<html><head></head><body><h1>Invalid Credentails</h1></body></html>");
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
