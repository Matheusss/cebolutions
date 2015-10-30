package com.cebolutions.top.car.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MARCA")
public class Marca extends AbstractEntity {
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="LOGO")
	private String logo;
	
	@Column(name="MARCAS_PRINCIPAIS")
	private Boolean principal;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Boolean getPrincipal() {
		return principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}
	

}
