package com.mfwp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mfwp.entity.CustomerProfile;
import com.mfwp.util.DbConnectionUtil;

public class CustomerProfileRepository {

	public int saveCustomerProfile(CustomerProfile customerProfile) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int profileUpdate = 0;
		
		try {
			connection = DbConnectionUtil.getDataBaseConnection();
			
			String query = null;
			String userIdQuery = "SELECT user_id FROM customerProfile WHERE user_id = ?";
			preparedStatement = connection.prepareStatement(userIdQuery);
			
			preparedStatement.setLong(1,customerProfile.getUserId());
			ResultSet resultSet = preparedStatement.executeQuery();
			

			if(resultSet.next()) {
				query = "UPDATE CustomerProfile SET first_name=?,last_name=?,"
						+ "gender=?,dateOfBirth=?,prefix=? where user_id=?";
			}
			else {
				query = "INSERT INTO CustomerProfile(first_name,last_name,"
						+ "gender,dateOfBirth,prefix,user_id) VALUES (?,?,?,?,?,?)";
			}
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, customerProfile.getFirstName());
			preparedStatement.setString(2, customerProfile.getLastName());
			preparedStatement.setString(3, customerProfile.getGender());
			preparedStatement.setString(4, customerProfile.getDateOfBirth());
			preparedStatement.setString(5, customerProfile.getPrefix());
			preparedStatement.setLong(6, customerProfile.getUserId());
			
			profileUpdate = preparedStatement.executeUpdate();
			
			if(profileUpdate == 1) {
				
				query = "SELECT Customer_id FROM CustomerProfile WHERE User_id = "+customerProfile.getUserId();
				preparedStatement = connection.prepareStatement(query);
				
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					
					customerProfile.setCustomerId(resultSet.getInt("Customer_id"));
				}
				
			}
			
			}
			catch(Exception e){
			e.printStackTrace(); 
		}
		
		return profileUpdate;
	}
	
	
	public List<CustomerProfile> getAllCustomerProfiles() {
		
		List<CustomerProfile> customerProfileList = new ArrayList<>();
	try {
		Connection connection = DbConnectionUtil.getDataBaseConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from CustomerProfile");
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			int customerId=resultSet.getInt("customerId");
			String firstName=resultSet.getString("firstName").trim();
			String lastName=resultSet.getString("lastName").trim();
			String gender=resultSet.getString("gender").trim();
			String dateOfBirth=resultSet.getString("dateOfBirth").trim();
			String prefix=resultSet.getString("prefix").trim();
			int userId=resultSet.getInt("userId");
			
			CustomerProfile customerProfile = new CustomerProfile();
			customerProfile.setCustomerId(customerId);
			customerProfile.setFirstName(firstName);
			customerProfile.setLastName(lastName);
			customerProfile.setGender(gender);
			customerProfile.setDateOfBirth(dateOfBirth);
			customerProfile.setPrefix(prefix);
			customerProfile.setUserId(userId);
			
			customerProfileList.add(customerProfile);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	 return customerProfileList;
	}
	
}
