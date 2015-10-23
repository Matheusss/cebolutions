/*package com.cebolutions.top.car.dto;

import java.util.ArrayList;
import java.util.List;

import com.cebolutions.top.car.entity.CarroVenda;
import com.cebolutions.top.car.entity.Estoque;

public class EstoqueDTO {
	
	private Long id;
	
	private List<CarroVendaDTO> carros = new ArrayList<CarroVendaDTO>();
	
	private Long quantidade;
	
	public EstoqueDTO(Estoque estoque){
		this.id = estoque.getId();

		if(estoque.getCarroVenda() != null){
			for (CarroVenda c : estoque.getCarroVenda()) {
				this.carros.add(new CarroVendaDTO(c));
			}
		}
		
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

	public List<CarroVendaDTO> getCarros() {
		return carros;
	}

	public void setCarros(List<CarroVendaDTO> carros) {
		this.carros = carros;
	}


}
*/