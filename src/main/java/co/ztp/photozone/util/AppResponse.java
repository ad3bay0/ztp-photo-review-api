/**
 * 
 */
package co.ztp.photozone.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**custom response message
 * @author Adebayo Adeniyan
 * Jul 4, 2019
 */
@ApiModel(description="custom api response json")
public class AppResponse {
	
	@ApiModelProperty(value="operation completion message")
	private String message;
	
	
	public AppResponse(String message) {
		
		this.message = message;
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
