package com.grupo22OO22023.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString(callSuper = true)
@Table(name = "smartParking")
public class SmartParking extends Dispositivo {
	
	@Column(name = "codigoLugarEstacionamiento", unique = true, nullable = false, updatable = false)
	private String codigoLugarEstacionamiento;
	
	@Column(name = "ocupado", nullable = false, columnDefinition = "boolean default false")
	private boolean ocupado;

	public SmartParking(String codigoLugarEstacionamiento) {
		super();
		this.codigoLugarEstacionamiento = codigoLugarEstacionamiento;
	}
}
