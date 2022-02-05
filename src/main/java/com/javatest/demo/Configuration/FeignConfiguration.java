package com.javatest.demo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.Decoder;
import feign.gson.GsonDecoder;

@Configuration
public class FeignConfiguration {
	
	@Bean
	public Decoder decoder() {
		return new GsonDecoder();
	}

}
