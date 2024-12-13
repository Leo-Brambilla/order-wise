package com.order_wise.clients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.order_wise.clients.infrastructure.persistence.entities") // Pacote das entidades
@EnableJpaRepositories(basePackages = "com.order_wise.clients.infrastructure.persistence.repositories") // Pacote dos repositórios JPA
public class ClientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientsApplication.class, args);
	}
}
