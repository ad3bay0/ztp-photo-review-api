/**
 * 
 */
package co.ztp.photozone.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.ztp.photozone.exception.ResourceNotFoundException;
import co.ztp.photozone.model.Photo;
import co.ztp.photozone.model.PhotoDTO;
import co.ztp.photozone.model.Rating;
import co.ztp.photozone.model.RatingDTO;
import co.ztp.photozone.repo.PhotoRepo;
import co.ztp.photozone.repo.RatingRepo;
import co.ztp.photozone.util.AppResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Adebayo Adeniyan
 * Jul 4, 2019
 */
@Api(description="photo resource endpoints")
@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class PhotoController {
	
	@Autowired
	private PhotoRepo photoRepo;
	
	@Autowired
	private RatingRepo  ratingRepo;
	
	@ApiOperation(value = "Get list of photos and average rating", response = Page.class)
	@GetMapping(value="/photos")
	public Page<Photo> getPhotos(Pageable pageable){
		
		return photoRepo.findAll(pageable);
		
	}
	
	
	@ApiOperation(value = "Save a photo url", response = ResponseEntity.class)
	@PostMapping(value="/photos")
	public ResponseEntity<?> createPhoto(@ApiParam(value = "url", required = true)
			@Valid @RequestBody PhotoDTO request){
		
		Photo photo = new Photo();
		photo.setUrl(request.getUrl());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(photoRepo.save(photo));
	}
	
	@ApiOperation(value = "Rate a photo by photo id", response = ResponseEntity.class)
	@PostMapping(value="/photos/{photoId}/ratings")
	public ResponseEntity<?> addingRatingToPhoto(@ApiParam(value = "id of the photo") @PathVariable (value = "photoId") UUID photoId,
			@Valid @RequestBody RatingDTO request){
		
		
		Rating rating = new Rating();
		rating.setValue(request.getValue());
	
		
		photoRepo.findById(photoId).map(photo->{
			
			rating.setPhoto(photo);
			
			return ratingRepo.save(rating);
			
		}).orElseThrow(()->new ResourceNotFoundException("No Photo found"));
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new AppResponse("photo rated successfully!"));
	}
	

}
