package com.grupo22OO22023.components;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AgregarEventos {
	
	@Scheduled(fixedDelay=15000)
	public void runJob() {
	}
}
