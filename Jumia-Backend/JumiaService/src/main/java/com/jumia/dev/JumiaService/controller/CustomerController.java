package com.jumia.dev.JumiaService.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.dev.JumiaService.dto.CustomerDto;
import com.jumia.dev.JumiaService.model.Customer;
import com.jumia.dev.JumiaService.service.CustomerService;

/**
 * Customer Endpoint for all customer operations
 * 
 * @author Mohammed Mostafa
 *
 */
@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping("jumia-api")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	/**
	 * Get all customers service
	 * 
	 * @return List<CustomerDto>
	 */
	@GetMapping("customers")
	public ResponseEntity<List<CustomerDto>> getAllCustomers() {

		List<Customer> customerList = customerService.getAllCustomers();

		logger.info("All customers returned successfully: " + customerList.size());

		List<CustomerDto> customerDtoList = customerList.stream().map(this::convertToDto).collect(Collectors.toList());

		return new ResponseEntity<List<CustomerDto>>(customerDtoList, HttpStatus.OK);

	}

	/**
	 * Save new customer service
	 * 
	 * @param Customer
	 */
	@PostMapping("customer")
	public void saveCustomer(@Valid @RequestBody Customer customer) {

		customerService.saveCustomer(customer);

		logger.info("Customer with name " + customer.getName() + " saved successfully");

	}

	/**
	 * Convert customer entity to customer dto
	 * 
	 * @param Customer
	 * @return CustomerDto
	 */
	private CustomerDto convertToDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setId(customer.getId());
		customerDto.setName(customer.getName());
		customerDto.setPhone(customer.getPhone());
		customerDto.setCountry(customer.getState().getCountry().getName());
		customerDto.setState(customer.getState().getName());
		return customerDto;
	}

}
