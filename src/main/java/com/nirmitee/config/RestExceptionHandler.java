package com.nirmitee.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nirmitee.dto.APIResponse;
import com.nirmitee.exception.DataNotStoredException;
import com.nirmitee.exception.EmptyResourceException;
import com.nirmitee.exception.InvalidInputException;
import com.nirmitee.exception.ResourceNotFoundException;
import com.nirmitee.utility.AppConstants;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice

public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	// other exception handlers
	private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

	@ExceptionHandler(value = { ResourceNotFoundException.class, EmptyResourceException.class })
	protected ResponseEntity<?> handleResourceNotFound(RuntimeException ex) {
		logger.error("Exception Is : ", ex.getMessage());
		APIResponse apiError = new APIResponse(ex.getMessage(), AppConstants.FAIL);
		return buildResponseEntity(apiError, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { InvalidInputException.class, DataNotStoredException.class })
	protected ResponseEntity<?> handleInvalidInput(RuntimeException ex) {
		logger.error("Exception Is : ", ex.getMessage());
		APIResponse apiError = new APIResponse(ex.getMessage(), AppConstants.FAIL);
		return buildResponseEntity(apiError, HttpStatus.BAD_REQUEST);
	}

	private ResponseEntity<?> buildResponseEntity(APIResponse apiError,
			HttpStatus httpStatus) {
		return new ResponseEntity<>(apiError, httpStatus);
	}

}