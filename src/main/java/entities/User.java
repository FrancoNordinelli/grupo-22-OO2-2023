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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@Getter @Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_user;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
	private Set<UserRole> userRoles = new HashSet<>();

	public User(String username, String password, Set<UserRole> userRoles) {
		super();
		this.username = username;
		this.password = password;
		this.userRoles = userRoles;
	}
	
	
	
}
