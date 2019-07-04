/**
 * 
 */
package co.ztp.photozone.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Adebayo Adeniyan
 * Jul 4, 2019
 */
@ApiModel(description="request body for rating model")
public class RatingDTO {
	@ApiModelProperty(value="rating score",required=true)
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}
