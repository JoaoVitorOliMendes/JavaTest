package com.javatest.demo.Services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatest.demo.Configuration.FeignConfiguration;
import com.javatest.demo.Models.EnderecoModel;

@FeignClient(name = "viacep", url = "http://viacep.com.br/ws", configuration = FeignConfiguration.class)
public interface EnderecoService {
	
	@RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
	EnderecoModel pesquisarCep(@PathVariable("cep") String cep);

}
