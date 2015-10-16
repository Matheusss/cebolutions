package com.cebolutions.top.car.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="COR")
public class Cor extends AbstractEntity {

	private String nome;
	
	private Long valor;

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
}
