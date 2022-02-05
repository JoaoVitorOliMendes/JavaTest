package com.javatest.demo.Services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatest.demo.Models.EnderecoModel;
import com.javatest.demo.Models.EntregaModel;
import com.javatest.demo.Repository.EnderecoRepository;
import com.javatest.demo.Repository.EntregasRepository;

@Service
public class EntregaService {
	
	@Autowired
	private EntregasRepository entregasRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	public Iterable<EntregaModel> searchAll() {
		return entregasRepository.findAll();
	}
	
	public EntregaModel searchById(BigInteger id) {
		Optional<EntregaModel> entrega = entregasRepository.findById(id);
		if(entrega.isPresent())
			return entrega.get();
		else
			return null;
	}
	
	public void insert(EntregaModel entrega) {
		LocalDateTime hoje = LocalDateTime.now();
		
		entrega = pesquisarEnderecoPorCep(entrega);
		entrega.setDataConsulta(hoje);
		entrega = calcularPreco(entrega);
		
		entregasRepository.save(entrega);
	}
	
	public void update(BigInteger id, EntregaModel entrega) {
		LocalDateTime hoje = LocalDateTime.now();
		
		Optional<EntregaModel> entregaSalva = entregasRepository.findById(id);
		if(entregaSalva.isPresent()) {
			entrega = pesquisarEnderecoPorCep(entrega);
			entrega.setDataConsulta(hoje);
			entrega = calcularPreco(entrega);		
			entregasRepository.save(entrega);
		}
	}
	
	public void delete(BigInteger id) {
		entregasRepository.deleteById(id);
	}
	
	private EntregaModel pesquisarEnderecoPorCep(EntregaModel entrega) {
		String cepOrigem = entrega.getCepOrigem().getCep();
		String cepDestino = entrega.getCepDestino().getCep();
		
		EnderecoModel enderecoOrigem = getOuPesquisarCep(cepOrigem);
		EnderecoModel enderecoDestino = getOuPesquisarCep(cepDestino);
		
		entrega.setCepOrigem(enderecoOrigem);
		entrega.setCepDestino(enderecoDestino);
		
		return entrega;
	}
	
	private EnderecoModel getOuPesquisarCep(String cep) {
		return enderecoRepository.findById(cep).orElseGet(() -> {
			EnderecoModel novoEndereco = enderecoService.pesquisarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
	}
	
	private EntregaModel calcularPreco(EntregaModel entrega) {
		if(entrega.getCepOrigem().getDdd().equals(entrega.getCepDestino().getDdd())) {
			BigDecimal valorTotal = entrega.getPeso().divide(new BigDecimal(2));
			entrega.setVlTotalFrete(valorTotal);
			
			LocalDateTime dataPrevista = entrega.getDataConsulta().plusDays(1);
			entrega.setDataPrevistaEntrega(dataPrevista);
		}else if(entrega.getCepOrigem().getUf().equals(entrega.getCepDestino().getUf())) {
			BigDecimal valorTotal = entrega.getPeso().divide(new BigDecimal(4));
			entrega.setVlTotalFrete(valorTotal);
			
			LocalDateTime dataPrevista = entrega.getDataConsulta().plusDays(3);
			entrega.setDataPrevistaEntrega(dataPrevista);
		}else {
			entrega.setVlTotalFrete(entrega.getPeso());
			
			LocalDateTime dataPrevista = entrega.getDataConsulta().plusDays(10);
			entrega.setDataPrevistaEntrega(dataPrevista);
		}
		
		return entrega;
	}

}
