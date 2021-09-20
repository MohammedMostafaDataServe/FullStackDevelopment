package com.jumia.dev.JumiaService.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jumia.dev.JumiaService.dao.CustomerRepository;
import com.jumia.dev.JumiaService.exception.NotValidFormatException;
import com.jumia.dev.JumiaService.model.Customer;

/**
 * CustomerService class provide all services related to customer entity and
 * connect with data layer
 * 
 * @author Mohammed Mostafa
 *
 */
@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	Logger logger = LoggerFactory.getLogger(CustomerService.class);

	/**
	 * Get all customers service
	 * 
	 * @return List<Customer>
	 */
	public List<Customer> getAllCustomers() {

		return customerRepository.findAll();

	}

	/**
	 * Save customer service
	 * 
	 * @return void
	 */
	public void saveCustomer(Customer customer) {

		if (isValidPhoneNumber(customer.getPhone())) {

			customerRepository.save(customer);

		} else {

			logger.error("Phone number not matched with country code: " + customer.getPhone());

			throw new NotValidFormatException("Phone number not matched with country code");
		}

	}

	/**
	 * Validate phone number against country code
	 * 
	 * @param phoneNumber
	 * @return boolean
	 */
	private boolean isValidPhoneNumber(String phoneNumber) {

		if (phoneNumber.substring(0, 5).equals("(237)")) {

			return phoneNumber.matches("\\(237\\)\\ ?[2368]\\d{7,8}$");

		} else if (phoneNumber.substring(0, 5).equals("(251)")) {

			return phoneNumber.matches("\\(251\\)\\ ?[1-59]\\d{8}$");

		} else if (phoneNumber.substring(0, 5).equals("(212)")) {

			return phoneNumber.matches("\\(212\\)\\ ?[5-9]\\d{8}$");

		} else if (phoneNumber.substring(0, 5).equals("(258)")) {

			return phoneNumber.matches("\\(258\\)\\ ?[28]\\d{7,8}$");

		} else if (phoneNumber.substring(0, 5).equals("(256)")) {

			return phoneNumber.matches("\\(256\\)\\ ?\\d{9}$");
		}
		return false;
	}

}
