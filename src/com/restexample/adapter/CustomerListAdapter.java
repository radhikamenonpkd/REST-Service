package com.restexample.adapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.restexample.constants.Constants;
import com.restexample.vo.CustomerListVO;

@Component
public class CustomerListAdapter {

	public static void main(String[] args) {

		CustomerListAdapter obj = new CustomerListAdapter();
		obj.readCustomerList();

	}

	public List<CustomerListVO> readCustomerList() {

		ClassPathResource csvFile = new ClassPathResource(Constants.CUSTOMER_LIST);
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		int i = 0;
		List<CustomerListVO> customerListVOs = new ArrayList<CustomerListVO>();
		try {
			br = new BufferedReader(new InputStreamReader(csvFile.getInputStream()));
			while ((line = br.readLine()) != null) {
				if (i == 0) {
					line = br.readLine();
				}
				i++;
				// use comma as separator
				String[] customerListArr = line.split(cvsSplitBy);
				CustomerListVO customerListVO = new CustomerListVO();
				customerListVO.setAddress(customerListArr[2]);
				customerListVO.setCustId(customerListArr[0]);
				customerListVO.setEmail(customerListArr[3]);
				customerListVO.setName(customerListArr[1]);
				customerListVO.setPhone(customerListArr[4]);
				
				customerListVO.setDiscount(customerListArr[10]);
				customerListVO.setDob(customerListArr[8]);
				customerListVO.setFirstName(customerListArr[6]);
				customerListVO.setLastName(customerListArr[7]);
				customerListVO.setHouseNumber(customerListArr[5]);
				customerListVO.setMaritalStatus(customerListArr[9]);
				
				customerListVOs.add(customerListVO);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return customerListVOs;
	}
	
	
	
	public CustomerListVO readCustomerList(String custId) {

		ClassPathResource csvFile = new ClassPathResource(Constants.CUSTOMER_LIST);
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		int i = 0;
		CustomerListVO customerListVO = new CustomerListVO();
		try {
			br = new BufferedReader(new InputStreamReader(csvFile.getInputStream()));
			while ((line = br.readLine()) != null) {
				if (i == 0) {
					line = br.readLine();
				}
				i++;
				// use comma as separator
				String[] customerListArr = line.split(cvsSplitBy);
				if(customerListArr[0].equals(custId)){
					customerListVO.setAddress(customerListArr[2]);
					customerListVO.setCustId(customerListArr[0]);
					customerListVO.setEmail(customerListArr[3]);
					customerListVO.setName(customerListArr[1]);
					customerListVO.setPhone(customerListArr[4]);
					
					customerListVO.setDiscount(customerListArr[10]);
					customerListVO.setDob(customerListArr[8]);
					customerListVO.setFirstName(customerListArr[6]);
					customerListVO.setLastName(customerListArr[7]);
					customerListVO.setHouseNumber(customerListArr[5]);
					customerListVO.setMaritalStatus(customerListArr[9]);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return customerListVO;
	}
	
	public CustomerListVO readCustomerList(String houseNumber, String firstName, String lastName) {

		ClassPathResource csvFile = new ClassPathResource(Constants.CUSTOMER_LIST);
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		int i = 0;
		CustomerListVO customerListVO = new CustomerListVO();
		try {
			br = new BufferedReader(new InputStreamReader(csvFile.getInputStream()));
			while ((line = br.readLine()) != null) {
				if (i == 0) {
					line = br.readLine();
				}
				i++;
				// use comma as separator
				String[] customerListArr = line.split(cvsSplitBy);
				if(customerListArr[5].toLowerCase().trim().equals(houseNumber.toLowerCase().trim()) 
						&& customerListArr[6].toLowerCase().trim().equals(firstName.toLowerCase().trim()) 
						&& customerListArr[7].toLowerCase().trim().equals(lastName.toLowerCase().trim())){
					
					customerListVO.setAddress(customerListArr[2]);
					customerListVO.setCustId(customerListArr[0]);
					customerListVO.setEmail(customerListArr[3]);
					customerListVO.setName(customerListArr[1]);
					customerListVO.setPhone(customerListArr[4]);
					
					customerListVO.setDiscount(customerListArr[10]);
					customerListVO.setDob(customerListArr[8]);
					customerListVO.setFirstName(customerListArr[6]);
					customerListVO.setLastName(customerListArr[7]);
					customerListVO.setHouseNumber(customerListArr[5]);
					customerListVO.setMaritalStatus(customerListArr[9]);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return customerListVO;
	}
}