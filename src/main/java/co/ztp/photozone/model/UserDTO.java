/**
 * 
 */
package co.ztp.photozone.model;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;

/**
 * @author Adebayo Adeniyan
 * Jul 3, 2019
 */
@ApiModel(description="request body for user model")

public class UserDTO {

	@NotBlank (message = "Username is mandatory")
	private String username;
	@NotBlank (message = "Password is mandatory")
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
