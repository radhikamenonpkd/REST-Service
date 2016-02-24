package com.restexample.adapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.restexample.constants.Constants;
import com.restexample.vo.CustomerDetailsVO;

@Component
public class CustomerDetailsAdapter {

	public static void main(String[] args) {

		CustomerDetailsAdapter obj = new CustomerDetailsAdapter();
		obj.readCustomerDetails();

	}

	public List<CustomerDetailsVO> readCustomerDetails() {

		ClassPathResource csvFile = new ClassPathResource(Constants.CUSTOMER_DETAILS);
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		int i = 0;
		List<CustomerDetailsVO> customerDetailsVOs = new ArrayList<CustomerDetailsVO>();
		try {
			br = new BufferedReader(new InputStreamReader(csvFile.getInputStream()));
			while ((line = br.readLine()) != null) {
				if (i == 0) {
					line = br.readLine();
				}
				i++;
				// use comma as separator
				String[] customerDetailsArr = line.split(cvsSplitBy);
				CustomerDetailsVO customerDetailsVO = new CustomerDetailsVO();
				customerDetailsVO.setAddress(customerDetailsArr[2]);
				customerDetailsVO.setCustId(customerDetailsArr[0]);
				customerDetailsVO.setEmail(customerDetailsArr[3]);
				customerDetailsVO.setName(customerDetailsArr[1]);
				customerDetailsVO.setPhone(customerDetailsArr[4]);
				customerDetailsVOs.add(customerDetailsVO);

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
		return customerDetailsVOs;
	}
	
	
	
	public CustomerDetailsVO readCustomerDetails(String custId) {

		ClassPathResource csvFile = new ClassPathResource(Constants.CUSTOMER_DETAILS);
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		int i = 0;
		CustomerDetailsVO customerDetailsVO = new CustomerDetailsVO();
		try {
			br = new BufferedReader(new InputStreamReader(csvFile.getInputStream()));
			while ((line = br.readLine()) != null) {
				if (i == 0) {
					line = br.readLine();
				}
				i++;
				// use comma as separator
				String[] customerDetailsArr = line.split(cvsSplitBy);
				if(customerDetailsArr[0].equals(custId)){
					customerDetailsVO.setAddress(customerDetailsArr[2]);
					customerDetailsVO.setCustId(customerDetailsArr[0]);
					customerDetailsVO.setEmail(customerDetailsArr[3]);
					customerDetailsVO.setName(customerDetailsArr[1]);
					customerDetailsVO.setPhone(customerDetailsArr[4]);
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
		return customerDetailsVO;
	}
}