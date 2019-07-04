/**
 * 
 */
package co.ztp.photozone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**Custom 
 * 404 exception
 * @author Adebayo Adeniyan
 * Jul 4, 2019
 */
@ResponseStatus( value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	 public ResourceNotFoundException() {
	        super();
	    }

	    public ResourceNotFoundException(String message) {
	        super(message);
	    }

	    public ResourceNotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
