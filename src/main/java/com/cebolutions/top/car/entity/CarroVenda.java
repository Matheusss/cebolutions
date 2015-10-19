package com.cebolutions.top.car.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CARRO_VENDA")
public class CarroVenda extends AbstractEntity{
	
	@ManyToOne
	@JoinColumn(name="CARRO_ID")
	private Carro carro;
	
	@ManyToOne
	@JoinColumn(name="COR_ID")
	private Cor cor;

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

}
