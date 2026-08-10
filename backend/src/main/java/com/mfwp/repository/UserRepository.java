package com.mfwp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mfwp.entity.User;
import com.mfwp.util.DbConnectionUtil;


public class UserRepository {

public int saveUser(User user) {
		
		int rowsUpdated =0;
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet =null;
		try {
			connection  = DbConnectionUtil.getDatabaseConnection();
			
			String roleQuery ="SELECT role_id from userrole where role_name ='"+user.getUserType()+"'";
			preparedStatement = connection.prepareStatement(roleQuery);
			resultSet=preparedStatement.executeQuery();
			
			Long roleId  = null;
			while(resultSet.next()) {
				roleId = resultSet.getLong("role_id");

				break;
			}
			System.out.println(resultSet.getLong("role_id"));

			String query = "INSERT INTO User (email,password,mobile_number,role_id) VALUES (?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getMobileNumber());
			preparedStatement.setLong(4, roleId);

			rowsUpdated = preparedStatement.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
		finally {
			
			try {
			connection.close();
			
			preparedStatement.close();
			
			resultSet.close();
			}
			catch (SQLException e) {
				e.printStackTrace(); 
			}
		}
		
		return rowsUpdated;
	}
	
	
	public boolean checkifEmailExists(User user) {
		
		try {
		Connection connection  = DbConnectionUtil.getDatabaseConnection();
			
		String query ="SELECT 1 FROM user WHERE email = ? LIMIT 1";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1,user.getEmail());
		ResultSet resultSet=preparedStatement.executeQuery();
		
		return resultSet.next();
		
		}
		catch (Exception e) {
			e.printStackTrace(); 
		}
		
		return false;
	}
	
	public boolean checkifMobileNumberExists(User user) {
		
		try {
		Connection connection  = DbConnectionUtil.getDatabaseConnection();
			
		String query ="SELECT 1 FROM user WHERE mobile_number = ? LIMIT 1";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1,user.getMobileNumber());
		ResultSet resultSet=preparedStatement.executeQuery();
		
		return resultSet.next();
		
		}
		catch (Exception e) {
			e.printStackTrace(); 
		}
		return false;
	}
	
	public boolean isValidUser(User user) {
		
		try {
			Connection connection  = DbConnectionUtil.getDatabaseConnection();
				
			String query ="SELECT 1 FROM user WHERE (mobile_number = ? AND password=?) OR (email = ? AND password=?) LIMIT 1";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1,user.getMobileNumber());
			preparedStatement.setString(2,user.getPassword());
			preparedStatement.setString(3,user.getEmail());
			preparedStatement.setString(4,user.getPassword());
			ResultSet resultSet=preparedStatement.executeQuery();
			
			return resultSet.next();
			
			}
			catch (Exception e) {
				e.printStackTrace(); 
			}
			return false;
		}
	
	
	
	public List<User> getAllUsers() {
		
		List<User> userList = new ArrayList<>();
	try {
		Connection connection = DbConnectionUtil.getDatabaseConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from user");
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			Long id=resultSet.getLong("user_id");
			String email=resultSet.getString("email").trim();
			String password=resultSet.getString("password").trim();
			String mobileNumber=resultSet.getString("mobile_number").trim();
			
			User user = new User();
			user.setUserId(id);
			user.setEmail(email);
			user.setMobileNumber(mobileNumber);
			user.setPassword(password);
			
			userList.add(user);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	 return userList;
	}

}
