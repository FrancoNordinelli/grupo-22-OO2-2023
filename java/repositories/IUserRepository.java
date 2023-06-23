package repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entities.User;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Serializable> {
	
	@Query("SELECT u FROM User u join fetch u.userRoles where u.username = (:usarneme)")
	public abstract User findByUsernameAndFetchUserRolesEagerly(@Param("username") String username);

}
