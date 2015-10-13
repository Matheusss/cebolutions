package com.cebolutions.top.car.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@NotNull
	@Column(name="NOME")
	private String nome;
	
	@NotNull
	@Column(name="SOBRENOME")
	private String sobrenome;
	
	@NotNull
	@Column(name="CPF")
	private String cpf;
	
	@NotNull
	@Column(name="CNH")
	private String cnh;
	
	/*@NotNull*/
	@Column(name="DT_NASCIMENTO")
	private Date dataNascimento;
	
	@Column(name="CEP")
	private String cep;

	@ManyToMany
	@JoinTable(name="ENDERECO_USUARIO", joinColumns = @JoinColumn(name="USER_ID"), inverseJoinColumns = @JoinColumn(name="ENDERECO_ID"))
	private List<Endereco> endereco = new ArrayList<>(); 
	
/*	@Column(name="USER")
	private String user;*/ 

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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}


/*	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}*/
}
