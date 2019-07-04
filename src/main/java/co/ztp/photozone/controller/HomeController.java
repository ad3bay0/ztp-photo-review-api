/**
 * 
 */
package co.ztp.photozone.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Adebayo Adeniyan
 * Jul 4, 2019
 */
@RestController
@CrossOrigin
public class HomeController {

	
	@RequestMapping(value="/",method={RequestMethod.GET,RequestMethod.POST})
	
	public ResponseEntity<?> home(){
		
		return ResponseEntity.ok("photo zone api");
	}
}
