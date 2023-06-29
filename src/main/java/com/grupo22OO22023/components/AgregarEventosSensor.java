package com.grupo22OO22023.components;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.grupo22OO22023.entities.SensorHumedad;
import com.grupo22OO22023.models.SHEventoModel;
import com.grupo22OO22023.repositories.ISensorHumedadRepository;
import com.grupo22OO22023.services.ISHEventoService;
import com.grupo22OO22023.services.ISensorHumedadService;

import jakarta.annotation.PostConstruct;

//@Component
public class AgregarEventosSensor {	
	//@Autowired
	private ISensorHumedadRepository shr;
	
	//@Autowired
	@Qualifier("SensorHumedad")
	private  ISHEventoService shI;
	private final Scanner sc;

	public AgregarEventosSensor(ISensorHumedadRepository shr, ISHEventoService shI) {
		this.shr = shr;
		this.shI = shI;
		this.sc = new Scanner(System.in);
	}
	
	//@PostConstruct garantiza que el método iniciar() se ejecute si shr no es null
	@PostConstruct
    public void inicializar() {
        SensorHumedad sensor = shr.findById(9);
        
        System.out.println("Nombre del evento: ");
        String nombreEvento = sc.nextLine();
        
        System.out.println("Regar? (true/false) :");
        boolean regar = sc.nextBoolean();
        //SHEventoModel nuevoEvento = new SHEventoModel(nombreEvento, sensor, regar);
        
        SHEventoModel ev = new SHEventoModel(nombreEvento, LocalDateTime.now(), sensor, regar);
        System.out.println(sensor);
        
        shI.insertOrUpdate(ev); 
    }
}
