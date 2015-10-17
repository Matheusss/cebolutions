package com.cebolutions.top.car.dto;

import com.cebolutions.top.car.entity.Carro;
import com.cebolutions.top.car.entity.Estoque;

public class EstoqueDTO {
	
	private Long id;
	
	private Carro carro;
	
	private Long quantidade;
	
	public EstoqueDTO(Estoque estoque){
		this.id = estoque.getId();
		this.carro = estoque.getCarro();
		this.quantidade = estoque.getQuantidade();
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

}
