package com.grupo22OO22023.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grupo22OO22023.entities.User;


@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Serializable>    {

	@Query("SELECT u FROM User u INNER JOIN FETCH u.userRoles WHERE u.username = (:username)")
	public abstract User findByUsernameAndFetchEagerly(@Param("username") String username);
}
