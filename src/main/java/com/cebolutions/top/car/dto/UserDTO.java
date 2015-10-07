package com.cebolutions.top.car.dto;

import com.cebolutions.top.car.entity.User;

public class UserDTO {

	private Long id;
	
	private String senha;
	
	private String email;
	
	private String nome;
	
	private String cpf;

	public UserDTO(User user){
		this.id = user.getId();
		this.senha = user.getSenha();
		this.email = user.getEmail();
		this.nome = user.getNome();
		this.cpf = user.getCpf();
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
