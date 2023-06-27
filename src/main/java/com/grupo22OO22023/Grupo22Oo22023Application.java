package com.grupo22OO22023;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
public class Grupo22Oo22023Application {
	public static void main(String[] args) {
		SpringApplication.run(Grupo22Oo22023Application.class, args);
	}
}
