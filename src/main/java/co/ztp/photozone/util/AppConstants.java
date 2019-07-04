/**
 * 
 */
package co.ztp.photozone.util;

import java.net.URI;

/**
 * @author Adebayo Adeniyan
 * Jul 4, 2019
 */
public class AppConstants {
	
	public static boolean isValid(String url) 
    { 
       
        try { 
            new URI(url).toURL(); 
            return true; 
        } 
          
  
        catch (Exception e) { 
            return false; 
        } 
    } 

}
