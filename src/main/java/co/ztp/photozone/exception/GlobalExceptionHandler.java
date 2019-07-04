/**
 * 
 */
package co.ztp.photozone.exception;

import java.util.Date;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import co.ztp.photozone.util.AppErrorResponse;

/**
 * This class handles exception specific and global exception in single place.
 * 
 * @author Adebayo Adeniyan Jul 4, 2019
 */

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)

	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {

		return buildResponseEntity(ex.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Exception.class)

	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {

		return buildResponseEntity("Invalid Operation", request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR);

	}


	public ResponseEntity<Object> buildResponseEntity(String message, String details, HttpStatus status) {

		return new ResponseEntity<>(new AppErrorResponse(new Date(), message, details), status);
	}

}
