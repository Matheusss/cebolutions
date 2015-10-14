package com.cebolutions.top.car.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
	
	@ElementCollection
	@CollectionTable(name="IMAGENS", joinColumns = @JoinColumn(name="CARRO_IAMGENS"))
	@Column(name="IMAGEM")
	private List<String> imagens = new ArrayList<String>();
	
	@Column(name="ANO")
	private Date ano;
	
	@Column(name="CV")
	private Long cv;
	
	@Column(name="MOTOR")
	private String motor;
	
/*	@Column(name="ESPECIFICACOES")
	private String specs;*/

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

	public List<String> getImagens() {
		return imagens;
	}

	public void setImagens(List<String> imagens) {
		this.imagens = imagens;
	}

	public Date getAno() {
		return ano;
	}

	public void setAno(Date ano) {
		this.ano = ano;
	}

	public Long getCv() {
		return cv;
	}

	public void setCv(Long cv) {
		this.cv = cv;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

/*	public String getSpecs() {
		return specs;
	}

	public void setSpecs(String specs) {
		this.specs = specs;
	}*/

}
