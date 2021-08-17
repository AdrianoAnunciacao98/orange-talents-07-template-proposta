package br.com.zupacademy.adriano.microservicepropostas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroservicePropostasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePropostasApplication.class, args);
	}

}
