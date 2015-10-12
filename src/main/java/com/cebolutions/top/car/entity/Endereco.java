package com.cebolutions.top.car.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ENDERECO")
public class Endereco extends AbstractEntity {
	
	@Column(name="CIDADE")
	private String cidade;
	
	@Column(name="ESTADO")
	private String estado;
	
	@Column(name="BAIRRO")
	private String bairro;
	
	@Column(name="logradouro")
	private String logradouro;

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	

}
