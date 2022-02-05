package com.javatest.demo.Controllers;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatest.demo.Models.EntregaModel;
import com.javatest.demo.Services.EntregaService;

@RestController
@RequestMapping("entregas")
public class EntregasController {

	@Autowired
	private EntregaService entregaService;
	
	@GetMapping
	public ResponseEntity<Iterable<EntregaModel>> searchAll() {
		return ResponseEntity.ok(entregaService.searchAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EntregaModel> searchById(@PathVariable BigInteger id) {
		return ResponseEntity.ok(entregaService.searchById(id));
	}
	
	@PostMapping
	public ResponseEntity<EntregaModel> insert(@RequestBody EntregaModel entrega) {
		entregaService.insert(entrega);
		return ResponseEntity.ok(entrega);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EntregaModel> update(@PathVariable BigInteger id, @RequestBody EntregaModel entrega) {
		entregaService.update(id, entrega);
		return ResponseEntity.ok(entrega);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<EntregaModel> delete(@PathVariable BigInteger id) {
		entregaService.delete(id);
		return ResponseEntity.ok().build();
	}

}
