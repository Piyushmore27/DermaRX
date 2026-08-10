package com.mfwp.service;

import java.util.List;

import com.mfwp.entity.CustomerProfile;
import com.mfwp.repository.CustomerProfileRepository;


public class CustomerProfileService {

	public int saveCustomerProfile(CustomerProfile customerProfile) {
		
		CustomerProfileRepository customerProfileRepository =new CustomerProfileRepository();
		
		return customerProfileRepository.saveCustomerProfile(customerProfile);
		}
		
		public List<CustomerProfile> getAllCustomerProfiles() {
			CustomerProfileRepository customerProfileRepository =new CustomerProfileRepository();
			return customerProfileRepository.getAllCustomerProfiles();
		}
	
}
