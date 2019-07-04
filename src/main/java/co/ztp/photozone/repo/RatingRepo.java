/**
 * 
 */
package co.ztp.photozone.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.ztp.photozone.model.Rating;

/**
 * @author Adebayo Adeniyan
 * Jul 4, 2019
 */
public interface RatingRepo extends CrudRepository<Rating, UUID> {
	
	@Query("SELECT AVG(r.value) FROM Rating r WHERE r.photo.id = ?1")
	Long findAverageRatingByPhotoId(UUID photo_id);
	

}
