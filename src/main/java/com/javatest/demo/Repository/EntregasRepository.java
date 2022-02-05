package com.javatest.demo.Repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatest.demo.Models.EntregaModel;


@Repository
public interface EntregasRepository extends CrudRepository<EntregaModel, BigInteger> {
	
	Optional<EntregaModel> findById(BigInteger id);
	
}
