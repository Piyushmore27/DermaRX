package com.mfwp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;
import com.mfwp.entity.ApiResponse;
import com.mfwp.entity.CustomerProfile;
import com.mfwp.entity.User;
import com.mfwp.service.CustomerProfileService;
import com.mfwp.service.UserService;

/**
 * Servlet implementation class UserProfileServlet
 */
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private static int createProfile(CustomerProfile customer) {
    	
    	CustomerProfileService profileService = new CustomerProfileService();
    	
    	return profileService.saveCustomerProfile(customer);
    	
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		
		User user = gson.fromJson(request.getReader(), User.class);
		
		CustomerProfile customer = new CustomerProfile();
		
		customer.setFirstName(request.getParameter("firstName"));
		customer.setLastName(request.getParameter("lastName"));
		customer.setPrefix(request.getParameter("prefix"));
		customer.setGender(request.getParameter("gender"));
		customer.setDateOfBirth(request.getParameter("DOB"));	
		customer.setUserId(user.getuserId());
		
		if(UserProfileServlet.createProfile(customer) == 1) {
			
			ApiResponse<CustomerProfile> customerAPI = new ApiResponse<>(
					true, "Profile Updated Successfully", customer);
			
			String json = gson.toJson(customerAPI);
			
			response.setContentType("application/json");
			response.getWriter().write(json);
		
		}else {
			
			ApiResponse<CustomerProfile> customerAPI = new ApiResponse<>(
					false, "Profile Updation Failed", customer);
			
			String json = gson.toJson(customerAPI);
			
			response.setContentType("application/json");
			response.getWriter().write(json);
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
