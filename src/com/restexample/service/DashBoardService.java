package com.restexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restexample.adapter.CustomerDetailsAdapter;
import com.restexample.adapter.CustomerListAdapter;
import com.restexample.vo.CustomerDetailsVO;
import com.restexample.vo.CustomerListVO;

@Component
public class DashBoardService {
	
	@Autowired
	private CustomerDetailsAdapter customerDetailsAdapter;
	
	@Autowired
	private CustomerListAdapter customerListAdapter;

	
	public List<CustomerDetailsVO> readCustomerDetails() {
		return customerDetailsAdapter.readCustomerDetails();
	}
	
	public CustomerDetailsVO readCustomerDetails(String custId) {
		return customerDetailsAdapter.readCustomerDetails(custId);
	}
	
	public List<CustomerListVO> readCustomerList() {
		return customerListAdapter.readCustomerList();
	}
	
	public CustomerListVO readCustomerList(String custId) {
		return customerListAdapter.readCustomerList(custId);
	}
	
	public CustomerListVO readCustomerList(String houseNumber, String firstName, String lastName) {
		return customerListAdapter.readCustomerList(houseNumber, firstName, lastName);
	}

	/**
	 * @param customerDetailsAdapter the customerDetailsAdapter to set
	 */
	public void setCustomerDetailsAdapter(CustomerDetailsAdapter customerDetailsAdapter) {
		this.customerDetailsAdapter = customerDetailsAdapter;
	}

	
}
