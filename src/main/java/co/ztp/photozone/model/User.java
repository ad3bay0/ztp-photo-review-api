/**
 * 
 */
package co.ztp.photozone.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * User model representing users
 * 
 * @author Adebayo Adeniyan
 * Jul 3, 2019
 */
@Entity
@Table(name="users")
public class User extends AuditModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
	
	@NotNull
	@Size(max=20,min=2)
	@Column(unique=true)
	@NotBlank (message = "Username is mandatory")
	private String username;
	
	@NotNull
	@JsonIgnore
	@Column
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
