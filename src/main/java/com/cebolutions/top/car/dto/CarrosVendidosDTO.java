package com.cebolutions.top.car.dto;

public class CarrosVendidosDTO {

	private Long id;
	
	private String modelo;
	
	private Integer numeroVendas;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getNumeroVendas() {
		return numeroVendas;
	}

	public void setNumeroVendas(Integer numeroVendas) {
		this.numeroVendas = numeroVendas;
	}
	
}
