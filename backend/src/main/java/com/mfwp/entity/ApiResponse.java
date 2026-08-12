package com.mfwp.entity;

public class ApiResponse<T> {
	
	private boolean success = false;
	private String message = "";
	private T object;
	
	public ApiResponse(boolean success, String message, T object){
		
		this.success = success;
		this.message = message;
		this.object = object;
	}
	
	
	public boolean isSuccess() {
		return success;
	}
	
	public String getMessage() {
		return message;
	}
	
	public T getObject() {
		return object;
	}

	
}
