package com.restexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.restexample.service.DashBoardService;
import com.restexample.vo.CustomerDetailsVO;
import com.restexample.vo.CustomerListVO;

@Controller
public class DashBoardController {
	
	@Autowired
	private DashBoardService dashBoardService;

	/**
	 * 
	 *
	 * @return ResponseEntity<List<CustomerDetailsVO>>
	 */
	@RequestMapping(value = "/customerDetails", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerDetailsVO>> getcustomer() {

		
		List<CustomerDetailsVO> customerDetailsVOs = dashBoardService.readCustomerDetails();

		return new ResponseEntity<List<CustomerDetailsVO>>(customerDetailsVOs, HttpStatus.OK);
	}
	
	/**
	 * 
	 *
	 * @param custId
	 * @return ResponseEntity<CustomerDetailsVO>
	 */
	@RequestMapping(value = "/customerDetails/{id}", method = RequestMethod.GET)
	public ResponseEntity<CustomerDetailsVO> getcustomer(@PathVariable("id") String custId) {

		CustomerDetailsVO customerDetailsVO = dashBoardService.readCustomerDetails(custId);

		return new ResponseEntity<CustomerDetailsVO>(customerDetailsVO, HttpStatus.OK);
	}
	
	/**
	 * 
	 *
	 * @param custId
	 * @return ResponseEntity<CustomerDetailsVO>
	 */
	@RequestMapping(value = "/customerList", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerListVO>> getcustomerList() {

		List<CustomerListVO> customerListVOs = dashBoardService.readCustomerList();

		return new ResponseEntity<List<CustomerListVO>>(customerListVOs, HttpStatus.OK);
	}
	
	/**
	 * 
	 *
	 * @param custId
	 * @return ResponseEntity<CustomerDetailsVO>
	 */
	@RequestMapping(value = "/customerList/{id}", method = RequestMethod.GET)
	public ResponseEntity<CustomerListVO> getcustomerList(@PathVariable("id") String custId) {

		CustomerListVO customerListVOs = dashBoardService.readCustomerList(custId);

		return new ResponseEntity<CustomerListVO>(customerListVOs, HttpStatus.OK);
	}
	/**
	 * 
	 *
	 * @param custId
	 * @return ResponseEntity<CustomerDetailsVO>
	 */
	@RequestMapping(value = "/customerList/{houseno}/{fname}/{lname}", method = RequestMethod.GET)
	public ResponseEntity<CustomerListVO> getcustomer(@PathVariable("houseno") String houseno, 
			@PathVariable("fname") String fname, 
			@PathVariable("lname") String lname) {

		CustomerListVO customerListVO = dashBoardService.readCustomerList(houseno, fname, lname);

		return new ResponseEntity<CustomerListVO>(customerListVO, HttpStatus.OK);
	}
	
	
	/**
	 * @param dashBoardService the dashBoardService to set
	 */
	public void setDashBoardService(DashBoardService dashBoardService) {
		this.dashBoardService = dashBoardService;
	}
	
	

}
