package com.cebolutions.top.car.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cebolutions.top.car.entity.Carro;
import com.cebolutions.top.car.entity.Marca;

public interface CarroRepository extends CrudRepository<Carro, Long> {

	List<Carro> findByMarca(Marca marca);
}
