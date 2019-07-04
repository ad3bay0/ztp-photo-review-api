/**
 * 
 */
package co.ztp.photozone.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.ztp.photozone.model.User;

/**
 * @author Adebayo Adeniyan
 * Jul 3, 2019
 */
public interface UserRepo extends CrudRepository<User, UUID> {

	User findByUsername(String username);
	
	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.username = :username")
    boolean existsByUsername(@Param("username") String username);
}
