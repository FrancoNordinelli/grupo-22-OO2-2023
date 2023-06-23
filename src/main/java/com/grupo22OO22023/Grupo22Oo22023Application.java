package com.grupo22OO22023;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories("paquete.de.repositorios")
@EntityScan("paquete.de.entidades")
public class Grupo22Oo22023Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupo22Oo22023Application.class, args);
	}

}
