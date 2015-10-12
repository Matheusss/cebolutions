package com.cebolutions.top.car.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CARRO")
public class Carro extends AbstractEntity {
	
	@Column(name="MODELO")
	private String modelo;
	
	@Column(name="PLACA")
	private String placa;
	
	@ManyToOne
	@JoinColumn(name="MARCA_ID")
	private Marca marca;
	
	@Column(name="COR")
	private String cor;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="ESPECIFICACOES")
	private String specs;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSpecs() {
		return specs;
	}

	public void setSpecs(String specs) {
		this.specs = specs;
	}

}
