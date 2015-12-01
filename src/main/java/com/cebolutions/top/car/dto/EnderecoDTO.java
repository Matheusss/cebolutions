package com.cebolutions.top.car.dto;

import com.cebolutions.top.car.entity.Endereco;
import com.cebolutions.top.car.entity.User;

public class EnderecoDTO {
	
	private Long id;
	
	private String estado;
	
	private String cidade;
	
	private String bairro;
	
	private String logradouro;
	
	private String cep;
	
	private User user;
	
	public Long getId() {
		return id;
	}
	
	public EnderecoDTO(Endereco endereco){
		this.id = endereco.getId();
		this.estado = endereco.getEstado();
		this.cidade = endereco.getCidade();
		this.bairro = endereco.getBairro();
		this.logradouro = endereco.getLogradouro();
		this.cep = endereco.getCep();
		this.user = endereco.getUser();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
