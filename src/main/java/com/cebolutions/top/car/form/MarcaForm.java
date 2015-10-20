package com.cebolutions.top.car.form;

import java.sql.Blob;

public class MarcaForm {

	private Long id;
	
	private String nome;
	
	private Blob logo;
	
	
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
	public Blob getLogo() {
		return logo;
	}
	public void setLogo(Blob logo) {
		this.logo = logo;
	}
	
}
