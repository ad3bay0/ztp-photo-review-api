/**
 * 
 */
package co.ztp.photozone.repo;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import co.ztp.photozone.model.Photo;

/**Photo dao
 * @author Adebayo Adeniyan
 * Jul 4, 2019
 */
public interface PhotoRepo extends PagingAndSortingRepository<Photo, UUID> {
	@Query("SELECT new co.ztp.photozone.model.Photo(p.id, p.url, ROUND(AVG(coalesce(r.value, 0)),0) AS average_rating) FROM Photo p LEFT JOIN Rating r ON p.id = r.photo.id GROUP BY p.id, p.url ORDER BY average_rating DESC")
	Page<Photo> findAll(Pageable page);

}
