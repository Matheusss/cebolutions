package com.cebolutions.top.car.dto;


import org.joda.time.LocalDate;

import com.cebolutions.top.car.entity.CarroVenda;
import com.cebolutions.top.car.entity.Endereco;
import com.cebolutions.top.car.entity.User;
import com.cebolutions.top.car.entity.Venda;
import com.cebolutions.top.car.json.LocalDateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class VendaDTO {

	private Long id;
	
	@JsonSerialize(using=LocalDateJsonSerializer.class)
	private LocalDate dataVenda;
	
	private Double valorTotal;
	
	private User usuario;
	
	private CarroVenda carro;
	
	private Boolean vendaCompleta;
	
	private Endereco enderecoEntrega;

	public VendaDTO(Venda venda){
		this.id = venda.getId();
		this.dataVenda = venda.getDate();
		this.valorTotal = venda.getValorTotal();
		this.usuario = venda.getUsuario();
		this.carro = venda.getCarro();
		this.vendaCompleta = venda.getVendaCompleta();
		this.enderecoEntrega = venda.getEnderecoEntrega();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
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

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	
}
