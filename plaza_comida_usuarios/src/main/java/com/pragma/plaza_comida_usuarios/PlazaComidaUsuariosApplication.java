package com.pragma.plaza_comida_usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication

public class PlazaComidaUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlazaComidaUsuariosApplication.class, args);
	}

}
