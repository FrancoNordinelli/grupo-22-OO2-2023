package repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.User;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Serializable>    {

}
