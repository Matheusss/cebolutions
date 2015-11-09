package com.cebolutions.top.car.dto;

import java.util.ArrayList;
import java.util.List;

import com.cebolutions.top.car.entity.Carro;
import com.cebolutions.top.car.entity.Cor;
import com.cebolutions.top.car.entity.Marca;

public class CarroDTO {

	private Long id;
	
	private String modelo;
	
	private Double preco;
	
	private Marca marca;
	
	private Cor cor;
	
	private String descricao;
	
	private Long ano;
	
	private Long cv;
	
	private Double motor;
	
	private Long topSpeed;
	
	private List<String> imagens = new ArrayList<String>();
	
	public CarroDTO(Carro carro){
		this.id = carro.getId();
		this.modelo = carro.getModelo();
		this.preco = carro.getPreco();
		this.marca = carro.getMarca();
		this.cor = carro.getCor();
		this.descricao = carro.getDescricao();
		this.ano = carro.getAno();
		this.cv = carro.getCv();
		this.motor = carro.getMotor();
		this.topSpeed = carro.getTopSpeed();
		
		if(carro.getImagens() != null){
			for (String s : carro.getImagens()) {
				this.imagens.add(s);
			}
		}
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Double getMotor() {
		return motor;
	}

	public void setMotor(Double motor) {
		this.motor = motor;
	}

	public Long getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(Long topSpeed) {
		this.topSpeed = topSpeed;
	}

	public List<String> getImagens() {
		return imagens;
	}

	public void setImagens(List<String> imagens) {
		this.imagens = imagens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
