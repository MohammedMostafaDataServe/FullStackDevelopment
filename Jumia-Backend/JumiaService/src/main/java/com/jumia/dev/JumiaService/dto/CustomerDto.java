package com.jumia.dev.JumiaService.dto;

import lombok.Data;

/**
 * Customer Data Access Object
 * 
 * @author Mohammed Mostafa
 *
 */
@Data
public class CustomerDto {
	
	private int id;
	private String name;
	private String phone;
	private String country;
	private String state;

}
