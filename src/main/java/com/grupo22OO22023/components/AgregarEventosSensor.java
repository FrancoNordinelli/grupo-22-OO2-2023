package com.grupo22OO22023.components;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
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

	private Random random = new Random();

	public AgregarEventosSensor(ISensorHumedadService shService, ISHEventoService shI) {
		this.shService = shService;
		this.shI = shI;
		this.sc = new Scanner(System.in);
	}

	@Override
	public void run() {

		while (true) {
			
			int id;
			try {
				id = getRandom();
				Optional<SensorHumedadModel> sensor = shService.findById(id);
				System.out.println("Nombre del evento: ");
				String nombreEvento = sc.nextLine();
				System.out.println("Regar? (true/false) :");
				boolean regar = sc.nextBoolean();
				SHEventoModel ev = new SHEventoModel(nombreEvento, LocalDateTime.now(), mp.map(sensor, SensorHumedad.class),
						regar);
				shI.insertOrUpdate(ev);
				System.out.println(sensor);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	

	private int getRandom() throws Exception {

		int id = 0;
		List<SensorHumedadModel> sensores = shService.getAll();
		if (!sensores.isEmpty()) {
			int randomIndex = random.nextInt(sensores.size());
			id = sensores.get(randomIndex).getId();
		} else {
			throw new Exception("No hay dispositivos");
		}
		return id;
	}

}
