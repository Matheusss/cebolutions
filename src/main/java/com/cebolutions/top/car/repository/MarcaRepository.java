package com.cebolutions.top.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cebolutions.top.car.entity.Marca;

public interface MarcaRepository extends CrudRepository<Marca, Long> {

	@Query("SELECT m FROM Marca m WHERE m.principal = true")
	List<Marca> findByPrincipalTrue();
	
/*	@Query("SELECT m.carro FROM Marca m WHERE m.principal = false")
	List<Carro> findByPrincipalFalse();*/
	
	@Query("SELECT m FROM Marca m WHERE m.principal = false")
	List<Marca> findByPrincipalFalse();
	
}
