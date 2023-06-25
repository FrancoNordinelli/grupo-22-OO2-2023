package com.grupo22OO22023.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor 
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEvento;
	@Column(name="nombreEvento", nullable = false)
	private String nombreEvento;
	@Column(name="instante", nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "dispositivoID", nullable = false)
	private SmartParking dispositivo;
	

	public Evento(String nombreEvento) {
		super();
		this.nombreEvento = nombreEvento;
	}
	public Evento(String nombreEvento, SmartParking dispositivo) {
		super();
		this.nombreEvento = nombreEvento;
		this.dispositivo = dispositivo;
	}
	public Evento(LocalDateTime createdAt, SmartParking dispositivo) {
		super();
		this.createdAt = createdAt;
		this.dispositivo = dispositivo;
	}
}
