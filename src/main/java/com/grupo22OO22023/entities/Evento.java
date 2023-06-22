package com.grupo22OO22023.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor 
public abstract class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEvento;
	@Column(name="nombreEvento", nullable = false)
	private String nombreEvento;
	@Column(name="instante", nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "evento_id", nullable = false)
	private Dispositivo dispositivo;
	

	public Evento(String nombreEvento) {
		super();
		this.nombreEvento = nombreEvento;
	}
	
	public Evento(String nombreEvento, Dispositivo dispositivo) {
		super();
		this.nombreEvento = nombreEvento;
		this.dispositivo = dispositivo;
	}
}
