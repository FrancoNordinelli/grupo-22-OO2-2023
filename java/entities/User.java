package entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	
	@Column(name = "pass", nullable = false)
	private String pass;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="user")
	private Set<UserRole>userRoles = new HashSet<UserRole>();

}
