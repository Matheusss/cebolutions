package com.cebolutions.top.car.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="COR")
public class Cor extends AbstractEntity {

	@Column(name="NOME")
	private String nome;
	
	@Column(name="VALOR")
	private Long valor;
	
	@Column(name = "COR_PADRAO", length = 1)
	private Boolean corDefault;
	
	@Column(name = "HEXADECIMAL")
	private String hexadecimal;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public boolean isCorDefault() {
		return getCorDefault();
	}

	public void setCorDefault(boolean corDefault) {
		this.corDefault = corDefault;
	}

	public String getHexadecimal() {
		return hexadecimal;
	}

	public void setHexadecimal(String hexadecimal) {
		this.hexadecimal = hexadecimal;
	}

	public Boolean getCorDefault() {
		return corDefault;
	}

	public void setCorDefault(Boolean corDefault) {
		this.corDefault = corDefault;
	}
}
