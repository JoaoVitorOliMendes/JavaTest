package com.javatest.demo.Models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class EntregaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;
	private BigDecimal peso;
	@ManyToOne
	private EnderecoModel cepOrigem;
	@ManyToOne
	private EnderecoModel cepDestino;
	private String nomeDestinatario;
	private BigDecimal vlTotalFrete;
	private LocalDateTime dataPrevistaEntrega;
	private LocalDateTime dataConsulta;
}
