package com.cebolutions.top.car.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VENDA")
public class Venda extends AbstractEntity {
	
	@Column(name="DT_VENDA")
	private LocalDateTime dataVenda;
	
	@Column(name="VALOR_TOTAL")
	private Double valorTotal;
	
	public LocalDateTime getDataVenda() {
		return dataVenda;
	}
	
	@ManyToOne
	@JoinColumn(name="USUARIO_ID")
	private User usuario;
	
	@ManyToOne
	@JoinColumn(name="CARRO_ID")
	private Carro carro;

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

}
