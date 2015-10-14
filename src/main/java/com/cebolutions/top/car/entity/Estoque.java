package com.cebolutions.top.car.entity;

import java.util.ArrayList;
import java.util.List;

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
	private List<Carro> carros = new ArrayList<Carro>();
	
	@Column(name="QUANTIDADE")
	@Min(2)
	@Max(99)
	private Long quantidade;


	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	
	

}
