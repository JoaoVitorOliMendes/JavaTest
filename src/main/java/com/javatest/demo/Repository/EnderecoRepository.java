package com.javatest.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatest.demo.Models.EnderecoModel;

@Repository
public interface EnderecoRepository extends CrudRepository<EnderecoModel, String> {

}
