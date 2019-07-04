/**
 * 
 */
package co.ztp.photozone.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.ztp.photozone.jwt.JwtRequest;
import co.ztp.photozone.jwt.JwtResponse;
import co.ztp.photozone.jwt.JwtTokenUtil;
import co.ztp.photozone.service.PhotoZoneUserDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Adebayo Adeniyan Jul 3, 2019
 */
@Api(description="user authentication")
@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private PhotoZoneUserDetailsService photoZoneUserDetailsService;

	@ApiOperation(value = "Generate jwt token with username and password", response = JwtResponse.class)
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> authenticate(@ApiParam(value = "username and password", required = true) @Valid @RequestBody JwtRequest request) throws Exception {

		authenticate(request.getUsername(), request.getPassword());

		final UserDetails userDetails = photoZoneUserDetailsService.loadUserByUsername(request.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));

	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}
