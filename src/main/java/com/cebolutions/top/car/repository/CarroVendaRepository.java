package com.cebolutions.top.car.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cebolutions.top.car.entity.Carro;
import com.cebolutions.top.car.entity.CarroVenda;

public interface CarroVendaRepository extends CrudRepository<CarroVenda, Long> {

	List<CarroVenda> findByCarro(Carro carro);
	
}
