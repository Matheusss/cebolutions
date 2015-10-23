/*package com.cebolutions.top.car.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="ESTOQUE")
public class Estoque extends AbstractEntity {
	
	@OneToMany(mappedBy="estoque")
	private List<CarroVenda> carroVenda = new ArrayList<>();
	
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

	public List<CarroVenda> getCarroVenda() {
		return carroVenda;
	}

	public void setCarroVenda(List<CarroVenda> carroVenda) {
		this.carroVenda = carroVenda;
	}

	
}
*/