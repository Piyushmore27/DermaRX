package com.mfwp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mfwp.entity.Address;
import com.mfwp.entity.CustomerProfile;
import com.mfwp.util.DbConnectionUtil;

public class AddressRepository {

public int saveAddress(Address address) {
		
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		int addressUpdate=0;
		try {
			connection = DbConnectionUtil.getDataBaseConnection();
	
			String query = "INSERT INTO Address(Line1,Line2,city,state,pincode,country,customer_id) VALUES (?,?,?,?,?,?,?)";
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, address.getLine1());
			preparedStatement.setString(2, address.getLine2());
			preparedStatement.setString(3, address.getCity());
			preparedStatement.setString(4, address.getState());
			preparedStatement.setString(5, address.getPincode());
			preparedStatement.setString(6, address.getCountry());
			preparedStatement.setInt(7, address.getCustomerId());
			
			addressUpdate=preparedStatement.executeUpdate();
			
			
			}
			catch(Exception e){
			e.printStackTrace(); 
		}
		return addressUpdate;
	}
	
	
	public List<Address> getAllAddress() {
		
		List<Address> addressList = new ArrayList<>();
	try {
		Connection connection = DbConnectionUtil.getDataBaseConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from address");
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			int addressId=resultSet.getInt("addressId");
			String line1=resultSet.getString("line1").trim();
			String line2=resultSet.getString("line2").trim();
			String gencityder=resultSet.getString("city").trim();
			String state=resultSet.getString("state").trim();
			String pincode=resultSet.getString("pincode").trim();
			String country=resultSet.getString("country");
			int customerId=resultSet.getInt("customerId");
			
			
			Address address = new Address();
			address.setAddressId(addressId);
			address.setLine1(line1);
			address.setLine2(line2);
			address.setCity(gencityder);
			address.setState(state);
			address.setPincode(pincode);
			address.setCountry(country);
			address.setCustomerId(customerId);
			
			addressList.add(address);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	 return addressList;
	}

	
}
