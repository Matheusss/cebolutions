package com.cebolutions.top.car.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MARCA")
public class Marca extends AbstractEntity {
	
	@Column(name="NAME")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
