package com.cebolutions.top.car.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cebolutions.top.car.entity.Endereco;
import com.cebolutions.top.car.entity.User;

public class UserDTO {

	private Long id;
	
	private String passsword;
	
	private String email;
	
	private String nome;
	
	private String sobrenome;
	
	private String cpf;
	
	private String cnh;
	
	private Date dataNascimento;
			
	private Boolean aprovado;
	
	private String username;

	public UserDTO(User user){
		this.id = user.getId();
		this.passsword = user.getPassword();
		this.email = user.getEmail();
		this.nome = user.getNome();
		this.sobrenome = user.getSobrenome();
		this.cpf = user.getCpf();
		this.cnh = user.getCnh();
		this.dataNascimento = user.getDataNascimento();
		this.aprovado = user.getAprovado();
		this.username = user.getUsername();
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return passsword;
	}

	public void setPassword(String senha) {
		this.passsword = senha;
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


	public String getSobrenome() {
		return sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public String getCnh() {
		return cnh;
	}


	public void setCnh(String cnh) {
		this.cnh = cnh;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Boolean getAprovado() {
		return aprovado;
	}


	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String user) {
		this.username = user;
	}
	
}
