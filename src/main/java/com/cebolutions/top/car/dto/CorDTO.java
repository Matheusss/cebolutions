package com.cebolutions.top.car.dto;

import com.cebolutions.top.car.entity.Cor;

public class CorDTO {
	
	private Long id;
	
	private String nome;
	
	private String hexadecimal;
	
	private Long valor;
	
	private Boolean corDefault;

	public CorDTO(Cor cor){
		this.id = cor.getId();
		this.nome=cor.getNome();
		this.hexadecimal=cor.getHexadecimal();
		this.valor=cor.getValor();
		this.corDefault=cor.getCorDefault();
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHexadecimal() {
		return hexadecimal;
	}

	public void setHexadecimal(String hexadecimal) {
		this.hexadecimal = hexadecimal;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public Boolean getCorDefault() {
		return corDefault;
	}

	public void setCorDefault(Boolean corDefault) {
		this.corDefault = corDefault;
	}
}
