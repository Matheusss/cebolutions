package com.cebolutions.top.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cebolutions.top.car.entity.Carro;
import com.cebolutions.top.car.entity.Venda;

public interface VendaRepository extends CrudRepository<Venda, Long> {
	
	@Query("SELECT v FROM Venda v WHERE v.carro.carro = ?1")
	List<Venda> findByCarro(Carro carro);
}
