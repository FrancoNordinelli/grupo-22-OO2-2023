package com.grupo22OO22023.models;

import com.grupo22OO22023.entities.Dispositivo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor 
public class EventoModel {
	private int idEvento;
	private String nombreEvento;
	
	@ToString.Exclude
	private Dispositivo dispositivo;
}
