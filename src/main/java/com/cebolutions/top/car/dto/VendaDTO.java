package com.cebolutions.top.car.dto;


import java.time.LocalDateTime;

import com.cebolutions.top.car.entity.CarroVenda;
import com.cebolutions.top.car.entity.User;
import com.cebolutions.top.car.entity.Venda;

public class VendaDTO {

	private Long id;
	
	private LocalDateTime dataVenda;
	
	private Double valorTotal;
	
	private User usuario;
	
	private CarroVenda carro;
	
	private Boolean vendaCompleta;

	public VendaDTO(Venda venda){
		this.id = venda.getId();
		this.dataVenda = venda.getDataVenda();
		this.valorTotal = venda.getValorTotal();
		this.usuario = venda.getUsuario();
		this.carro = venda.getCarro();
		this.vendaCompleta = venda.getVendaCompleta();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public CarroVenda getCarro() {
		return carro;
	}

	public void setCarro(CarroVenda carro) {
		this.carro = carro;
	}

	public Boolean getVendaCompleta() {
		return vendaCompleta;
	}

	public void setVendaCompleta(Boolean vendaCompleta) {
		this.vendaCompleta = vendaCompleta;
	}
	
}
