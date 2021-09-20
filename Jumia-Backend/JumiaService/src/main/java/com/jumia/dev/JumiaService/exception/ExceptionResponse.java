package com.jumia.dev.JumiaService.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * ExceptionResponse class to provide readable exception response
 * 
 * @author Mohammed Mostafa
 *
 */
@Setter @Getter
@AllArgsConstructor
public class ExceptionResponse {
	
	private Date time;
	private String message;
	private String details;

}
