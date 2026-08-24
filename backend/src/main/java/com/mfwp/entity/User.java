package com.mfwp.entity;

public class User {

	private Long userId;//Pk autoincrement
	private String email;//unquie
	private String password;
	private String mobileNumber;//unique
	private String username;//foreign key  userRole
	private String userType;
	
	
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Long getuserId() {
		return userId;
	}
	public void setUserId(Long id) {
		this.userId = id;
	} 
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
