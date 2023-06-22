package com.grupo22OO22023.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
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
public abstract class Dispositivo{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	@NotNull
	@Column(name = "nombreDispositivo", nullable = false)
	protected String nombreDispositivo;
	@NotNull
	@Column(name = "estadoDispositivo", nullable = false, columnDefinition = "boolean default true")
	protected boolean estadoDispositivo;
	@NotNull
	@Column(name="descripcionDispositivo", nullable = false)
	protected String descripcion;
	@Column(name="updatedAt", nullable = false)
	@UpdateTimestamp
	protected LocalDateTime updatedAt;
	@Column(name="createdAt", nullable = false, updatable = false)
	@CreationTimestamp
	protected LocalDateTime createdAt;

	public Dispositivo(@NotNull String nombreDispositivo, @NotNull boolean estadoDispositivo,
			@NotNull String descripcion) {
		super();
		this.nombreDispositivo = nombreDispositivo;
		this.estadoDispositivo = estadoDispositivo;
		this.descripcion = descripcion;
	}
}
