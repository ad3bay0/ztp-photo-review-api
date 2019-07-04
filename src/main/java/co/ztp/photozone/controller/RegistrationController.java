/**
 * 
 */
package co.ztp.photozone.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.ztp.photozone.model.UserDTO;
import co.ztp.photozone.service.PhotoZoneUserDetailsService;
import co.ztp.photozone.util.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Adebayo Adeniyan
 * Jul 3, 2019
 */
@Api(description="user creation endpoint")
@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class RegistrationController {
	
	@Autowired
	private PhotoZoneUserDetailsService photoZoneUserDetailsService;
	
	@ApiOperation(value = "Create User", response = ResponseEntity.class)
	@PostMapping(value = "/register")
	public ResponseEntity<?> saveUser(@ApiParam("username & password") @Valid @RequestBody UserDTO user) throws Exception {
		
		
		photoZoneUserDetailsService.save(user);
		
		return  ResponseEntity.status(HttpStatus.CREATED).body(new AppResponse("User created successfully"));
	}

}
