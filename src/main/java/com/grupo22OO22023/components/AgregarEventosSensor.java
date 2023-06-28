package com.grupo22OO22023.components;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupo22OO22023.entities.SensorHumedad;
import com.grupo22OO22023.models.SHEventoModel;
import com.grupo22OO22023.repositories.ISensorHumedadRepository;

import jakarta.annotation.PostConstruct;

@Component
public class AgregarEventosSensor {

	
	@Autowired
	private ISensorHumedadRepository shr;
	
	private final Scanner sc;
	
	public AgregarEventosSensor(ISensorHumedadRepository shr) {
		this.shr = shr;
		this.sc = new Scanner(System.in);
	}
	
	
	//@PostConstruct garantiza que el método iniciar() se ejecute si shr no es null
	@PostConstruct
    public void inicializar() {
        SensorHumedad sensor = shr.findById(4);
        
        System.out.println("Nombre del evento: ");
        String nombreEvento = sc.nextLine();
        
        System.out.println("Regar? (true/false) :");
        boolean regar = sc.nextBoolean();
        SHEventoModel nuevoEvento = new SHEventoModel(nombreEvento, sensor, regar);
        // Puedes hacer algo con nuevoEvento aquí
        System.out.println(nuevoEvento);
        System.out.println(sensor);
    }
	
}
