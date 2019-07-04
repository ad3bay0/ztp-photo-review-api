/**
 * 
 */
package co.ztp.photozone.util;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** a simple error response bean
 * @author Adebayo Adeniyan Jul 4, 2019
 */
@ApiModel(description="error response json")
public class AppErrorResponse {

	@ApiModelProperty(value="time error occured")
	private Date timestamp;
	
	@ApiModelProperty(value="error message")
	private String message;
	
    @ApiModelProperty(value="misc error message")
	private String details;

	public AppErrorResponse(Date timestamp, String message, String details) {

		super();

		this.timestamp = timestamp;

		this.message = message;

		this.details = details;

	}

	public Date getTimestamp() {

		return timestamp;

	}

	public String getMessage() {

		return message;

	}

	public String getDetails() {

		return details;

	}

}
