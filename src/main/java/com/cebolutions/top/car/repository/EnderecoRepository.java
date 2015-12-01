package com.cebolutions.top.car.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cebolutions.top.car.entity.Endereco;
import com.cebolutions.top.car.entity.User;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

	List<Endereco> findByUser(User u);
	
}
