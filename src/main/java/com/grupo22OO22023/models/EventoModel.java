package com.grupo22OO22023.models;

import java.time.LocalDateTime;

import com.grupo22OO22023.entities.SmartParking;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor 
public abstract class EventoModel {
	private int idEvento;
	private String nombreEvento;
	private LocalDateTime createdAt; 
	@ToString.Exclude
	private SmartParking dispositivo;	

	public EventoModel(String nombreEvento, SmartParking dispositivo) {
		super();
		this.nombreEvento = nombreEvento;
		this.dispositivo = dispositivo;
	}
	public EventoModel(LocalDateTime createdAt, SmartParking dispositivo) {
		super();
		this.createdAt = createdAt;
		this.dispositivo = dispositivo;
	}
}
