package com.cebolutions.top.car.dto;

import com.cebolutions.top.car.entity.Carro;
import com.cebolutions.top.car.entity.CarroVenda;
import com.cebolutions.top.car.entity.Cor;

public class CarroVendaDTO {

	private Long id;
	
	private Carro carro;
	
	private Cor cor;

	public Carro getCarro() {
		return carro;
	}
	
	public CarroVendaDTO(CarroVenda carroVenda){
		this.id = carroVenda.getId();
		this.carro = carroVenda.getCarro();
		this.cor = carroVenda.getCor();
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
