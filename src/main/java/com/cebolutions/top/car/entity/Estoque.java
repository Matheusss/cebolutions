package com.cebolutions.top.car.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="ESTOQUE")
public class Estoque extends AbstractEntity {
	
	@OneToMany
	@JoinColumn(name="CARRO_ID")
	private Set<Carro> carros = new HashSet<>();
	
	@Column(name="QUANTIDADE")
	@Min(2)
	@Max(99)
	private Long quantidade;

	public Set<Carro> getCarros() {
		return carros;
	}

	public void setCarros(Set<Carro> carros) {
		this.carros = carros;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
