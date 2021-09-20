package com.jumia.dev.JumiaService.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jumia.dev.JumiaService.model.Customer;

/**
 * CustomerControllerTest to make unit testing on customer entity services
 * 
 * @author Mohammed Mostafa
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void saveCustomer() throws Exception {
		String uri = "/jumia-api/customer";
		Customer customer = new Customer();
		customer.setName("Sami");
		// customer.setPhone("23456");
		// customer.setPhone("202 23456789");
		// customer.setPhone("202-23456789");
		//customer.setPhone("(256) 8491866888888888");
		customer.setPhone("(258) 849181828");
		String inputJson = mapToJson(customer);
		mockMvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andExpect(status().isOk());

	}

	@Test
	public void getAllCustomers() throws Exception {
		String uri = "/jumia-api/customers";
		mockMvc.perform(MockMvcRequestBuilders.get(uri)).andExpect(status().isOk());

	}

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	protected <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}

}
