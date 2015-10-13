package com.cebolutions.top.car.dto;

import com.cebolutions.top.car.entity.Marca;

public class MarcaDTO {
	
	private Long id;
	
	private String nome;
	
	private String logo;
	
	public MarcaDTO(Marca marca){
		this.id = marca.getId();
		this.nome = marca.getNome();
		this.logo = marca.getLogo();
	}

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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}
