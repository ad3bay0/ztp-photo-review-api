/**
 * 
 */
package co.ztp.photozone.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import co.ztp.photozone.model.User;

/**
 * @author Adebayo Adeniyan
 * Jul 3, 2019
 */
public interface UserRepo extends CrudRepository<User, UUID> {

	User findByUsername(String username);
}
