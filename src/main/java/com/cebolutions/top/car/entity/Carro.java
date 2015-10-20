package com.cebolutions.top.car.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CARRO")
public class Carro extends AbstractEntity {
	
	@Column(name="MODELO")
	private String modelo;
	
	@Column(name="PRECO")
	private Double preco;
	
	@Column(name="PLACA")
	private String placa;
	
	@ManyToOne
	@JoinColumn(name="MARCA_ID")
	private Marca marca;
	
	@OneToOne
	@JoinColumn(name="CARRO_COR")
	private Cor cor;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@ElementCollection
	@CollectionTable(name="IMAGENS", joinColumns = @JoinColumn(name="CARRO_IMAGENS"))
	@Column(name="IMAGEM")
	private List<String> imagens = new ArrayList<String>();
	
/*	@ElementCollection
	@CollectionTable(name="IMAGES", joinColumns = @JoinColumn(name="CARRO_IMAGES"))
	@Column(name="IMAGE")
	private List<Blob> images = new ArrayList<Blob>();*/
	
	@Column(name="ANO")
	private Long ano;
	
	@Column(name="CV")
	private Long cv;
	
	
	//0 - 60mph
	@Column(name="MOTOR")
	private Long motor;
	
	@Column(name="TOP_SPEED")
	private Long topSpeed;
	
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

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public Long getCv() {
		return cv;
	}

	public void setCv(Long cv) {
		this.cv = cv;
	}

	public Long getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(Long topSpeed) {
		this.topSpeed = topSpeed;
	}

	public Long getMotor() {
		return motor;
	}

	public void setMotor(Long motor) {
		this.motor = motor;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

/*	public List<Blob> getImages() {
		return images;
	}

	public void setImages(List<Blob> images) {
		this.images = images;
	}*/

/*	public String getSpecs() {
		return specs;
	}

	public void setSpecs(String specs) {
		this.specs = specs;
	}*/

}
