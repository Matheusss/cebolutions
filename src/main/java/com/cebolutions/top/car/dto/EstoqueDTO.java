package com.cebolutions.top.car.dto;

import java.util.ArrayList;
import java.util.List;

import com.cebolutions.top.car.entity.Carro;
import com.cebolutions.top.car.entity.Estoque;

public class EstoqueDTO {
	
	private Long id;
	
	private List<CarroDTO> carros = new ArrayList<CarroDTO>();
	
	private Long quantidade;
	
	public EstoqueDTO(Estoque estoque){
		this.id = estoque.getId();
		if (estoque.getCarros() != null){
			for (Carro c : estoque.getCarros()) {
				this.carros.add(new CarroDTO(c));
			}
		}
		
		this.quantidade = estoque.getQuantidade();
	}

	public List<CarroDTO> getCarros() {
		return carros;
	}

	public void setCarros(List<CarroDTO> carros) {
		this.carros = carros;
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

}
