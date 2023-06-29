package com.grupo22OO22023.models;

import java.time.LocalDateTime;

import com.grupo22OO22023.entities.Dispositivo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor 
public class EventoModel {
	private int idEvento;
	private String nombreEvento;
	private LocalDateTime createdAt; 
	private Dispositivo dispositivo;	

	public EventoModel(String nombreEvento, Dispositivo dispositivo) {
		super();
		this.nombreEvento = nombreEvento;
		this.dispositivo = dispositivo;
	}
	public EventoModel(LocalDateTime createdAt, Dispositivo dispositivo) {
		super();
		this.createdAt = createdAt;
		this.dispositivo = dispositivo;
	}
	public EventoModel(String nombreEvento, LocalDateTime createdAt, Dispositivo dispositivo) {
		super();
		this.nombreEvento = nombreEvento;
		this.createdAt = createdAt;
		this.dispositivo = dispositivo;
	}
	
	
	
}
