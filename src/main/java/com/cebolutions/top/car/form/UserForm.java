package com.cebolutions.top.car.form;

import java.util.Date;
import java.util.List;

public class UserForm {
	
	private String senha;
	
	private String email;
	
	private String nome;
	
	private String sobrenome;
	
	private String cpf;
	
	private String cnh;
	
	private Date dataNascimento;
		
	
	private List<Long> enderecoId;
	
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
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	
	public List<Long> getEnderecoId() {
		return enderecoId;
	}
	public void setEnderecoId(List<Long> enderecoId) {
		this.enderecoId = enderecoId;
	}
	
}
