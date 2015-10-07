package com.cebolutions.top.car.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="USER")
public class User extends AbstractEntity {

	@NotNull
	@Column(name="SENHA")
	private String senha; 
	
	@NotNull
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="CPF")
	private String cpf;

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
