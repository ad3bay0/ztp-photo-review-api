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
@ApiModel(description="request body for Photo model")
public class PhotoDTO {
	@ApiModelProperty(value="photo url",required=true)
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
