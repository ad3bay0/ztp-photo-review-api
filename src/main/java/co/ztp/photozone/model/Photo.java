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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
 * 
 * @author Adebayo Adeniyan
 * Jul 3, 2019
 */
@Entity
@Table(name="photos")
@ApiModel(description = "Photo model")
public class Photo extends AuditModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	
	@NotNull
	@Column
	@ApiModelProperty(value = "url of the photo", required=true)
	private String url;
	
	@Transient
	@ApiModelProperty(value="average rating of a photo")
	private Double averageRating = 0.0;
	
	public Photo() {}
	
	public Photo(UUID id,String url ,Double averageRating) {
		this.id = id;
		this.url = url;
		this.averageRating = averageRating;
		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Double averageRating) {
		this.averageRating = averageRating;
	}
	
	

}
