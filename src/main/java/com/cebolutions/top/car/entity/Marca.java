package com.cebolutions.top.car.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.sql.Blob;

@Entity
@Table(name="MARCA")
public class Marca extends AbstractEntity {
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="LOGO")
	private Blob logo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Blob getLogo() {
		return logo;
	}

	public void setLogo(Blob logo) {
		this.logo = logo;
	}
	

}
