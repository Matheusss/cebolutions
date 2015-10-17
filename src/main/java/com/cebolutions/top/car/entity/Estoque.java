package com.cebolutions.top.car.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="ESTOQUE")
public class Estoque extends AbstractEntity {
	
	@OneToOne
	@JoinColumn(name="CARRO_ID")
	private Carro carro;
	
	@Column(name="QUANTIDADE")
	@Min(2)
	@Max(5)
	private Long quantidade;


	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	

}
