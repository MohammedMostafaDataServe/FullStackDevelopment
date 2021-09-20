package com.jumia.dev.JumiaService.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotValidFormatException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotValidFormatException(String message) {

		super(message);

	}

	public NotValidFormatException(String message, Exception ex) {

		super(message, ex);

	}

}
