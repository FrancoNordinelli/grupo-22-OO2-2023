package com.grupo22OO22023.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "spEvento")
public class SPEvento extends Evento{
	@Column(name = "horasOcupado")
	private long horasOcupado;

	public SPEvento(String nombreEvento, SmartParking dispositivo, long horasOcupado) {
		super(nombreEvento, dispositivo);
		this.horasOcupado = horasOcupado;
	}
	public SPEvento(LocalDateTime createdAt, SmartParking dispositivo) {
		super(createdAt, dispositivo);
	}
}
