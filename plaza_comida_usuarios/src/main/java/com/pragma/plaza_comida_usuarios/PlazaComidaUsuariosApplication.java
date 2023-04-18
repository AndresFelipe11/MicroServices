package com.pragma.plaza_comida_usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PlazaComidaUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlazaComidaUsuariosApplication.class, args);
	}

}
