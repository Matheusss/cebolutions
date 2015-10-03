package com.cebolutions.top.car.dto;

import javax.validation.constraints.NotNull;

import com.cebolutions.top.car.entity.Premio;



public class PremioDTO {
	
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private Integer valor;
	
	public PremioDTO() {

	}
	
	public PremioDTO(Premio premio) {
		this.id = premio.getId();
		this.nome = premio.getNome();
		this.valor = premio.getValor();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
