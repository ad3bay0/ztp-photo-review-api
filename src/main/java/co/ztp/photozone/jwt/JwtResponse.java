/**
 * 
 */
package co.ztp.photozone.jwt;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is required for creating a response containing the JWT to be
 * returned to the user.
 * 
 * @author Adebayo Adeniyan Jul 3, 2019
 */
@ApiModel
public class JwtResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8652060506934246512L;
	@ApiModelProperty(value="jwt token generated after user is authenticated")
	private final String token;

	public JwtResponse(String token) {

		this.token = token;
	}

	public String getToken() {
		return this.token;
	}
	
	
}
