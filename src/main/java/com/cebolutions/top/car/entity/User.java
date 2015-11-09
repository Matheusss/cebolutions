package com.cebolutions.top.car.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User extends AbstractEntity {

	@Column(name="SENHA")
	private String senha; 
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="SOBRENOME")
	private String sobrenome;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="CNH")
	private String cnh;
	
	@Column(name="DT_NASCIMENTO")
	private Date dataNascimento;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="ENDERECO_USUARIO", joinColumns = @JoinColumn(name="USER_ID"), inverseJoinColumns = @JoinColumn(name="ENDERECO_ID"))
	private List<Endereco> endereco = new ArrayList<>(); 
	
	//DADOS VENDA
	@Column(name="NUMERO_CARTAO")
	private Long numeroCartao;
	
	@Column(name="DT_CARTAO")
	private Date dtCartao;
	
	@Column(name="APROVADO")
	private Boolean aprovado;
	
	@Column(name = "USER")
	private String user;

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

	public Long getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(Long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public Date getDtCartao() {
		return dtCartao;
	}

	public void setDtCartao(Date dtCartao) {
		this.dtCartao = dtCartao;
	}

	public Boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}


	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
