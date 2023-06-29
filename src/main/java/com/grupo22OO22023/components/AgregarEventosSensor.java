package com.grupo22OO22023.components;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Qualifier;


import com.grupo22OO22023.entities.SensorHumedad;
import com.grupo22OO22023.models.SHEventoModel;
import com.grupo22OO22023.models.SensorHumedadModel;

import com.grupo22OO22023.services.ISHEventoService;
import com.grupo22OO22023.services.ISensorHumedadService;


public class AgregarEventosSensor implements Runnable {
	
	
	
	@Qualifier("SensorHumedad")
	private ISensorHumedadService shService;
	@Qualifier("SHEvento")
	private ISHEventoService shI;
	
	private ModelMapper mp = new ModelMapper();
	
	private final Scanner sc;

	public AgregarEventosSensor(ISensorHumedadService shService, ISHEventoService shI) {
		this.shService = shService;
		this.shI = shI;
		this.sc = new Scanner(System.in);
	}

	@Override
	public void run() {

		Optional<SensorHumedadModel> sensor = shService.findById(1);
		
		System.out.println("Nombre del evento: ");
		String nombreEvento = sc.nextLine();

		System.out.println("Regar? (true/false) :");
		boolean regar = sc.nextBoolean();
		
		SHEventoModel ev = new SHEventoModel(nombreEvento, LocalDateTime.now(), mp.map(sensor, SensorHumedad.class), regar);
		System.out.println(sensor);

		shI.insertOrUpdate(ev);

	}
}
