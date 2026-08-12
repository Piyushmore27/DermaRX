package com.mfwp.service;

import java.util.List;

import com.mfwp.entity.Address;
import com.mfwp.repository.AddressRepository;


public class AddressService {

	public int saveAddress(Address address) {
		
		AddressRepository addressRepository =new AddressRepository();
		return addressRepository.saveAddress(address);
		}
		
		public List<Address> getAllAddress() {
			AddressRepository addressRepository =new AddressRepository();
			return addressRepository.getAllAddress();
		}
}
