package com.grupo22OO22023.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
@Table(name = "dispositivo") 
@Inheritance(strategy = InheritanceType.JOINED)
public class Dispositivo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name = "nombreDispositivo", nullable = false)
	private String nombreDispositivo;
	
	@Column(name = "estadoDispositivo", nullable = false, 
			columnDefinition = "boolean default true")
	private boolean estadoDispositivo;
	
	@OneToMany(mappedBy = "dispositivo", 
			fetch = FetchType.LAZY)
	@ToString.Exclude
	private Set<Evento> eventos;
}
