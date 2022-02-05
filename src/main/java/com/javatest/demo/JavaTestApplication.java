package com.javatest.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableFeignClients
@SpringBootApplication
@EnableSwagger2
public class JavaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaTestApplication.class, args);
	}

}
/*
 	Exemplo de requisicao POST:
  	{
  		"cepDestino": {
    		"cep": "08090-284"
  		},
  		"cepOrigem": {
    		"cep": "31070020"
  		},
  		"nomeDestinatario": "Joao Vitor de Oliveira Mendes",
  		"peso": 10.5
	}
	
	Para acessar swagger-ui:
	http://localhost:8080/swagger-ui.html
	
	Caso estiver testando a aplicacao localmente:
		- Criar Banco de dados MySql JavaTest
		- Mudar Application.properties para a configuracao do banco de dados
		
	Caso Docker
		- docker-compose up
	
 */