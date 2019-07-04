/**
 * 
 */
package co.ztp.photozone.jwt;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is required for storing the username and password we received from
 * the client.
 * 
 * @author Adebayo Adeniyan Jul 3, 2019
 */
@ApiModel(description="request body parameters used for authentication and jwt token generation after validation")
public class JwtRequest implements Serializable {

	@ApiModelProperty(value="username of ther user",required=true)
	private String username;
	@ApiModelProperty(value="password of the user",required=true)
	private String password;

	// need default constructor for JSON Parsing
	public JwtRequest() {

	}

	public JwtRequest(String username, String password) {

		this.setUsername(username);

		this.setPassword(password);

	}

	public String getUsername() {

		return this.username;

	}

	public void setUsername(String username) {

		this.username = username;

	}

	public String getPassword() {

		return this.password;

	}

	public void setPassword(String password) {

		this.password = password;

	}

}
