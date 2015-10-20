package com.cebolutions.top.car.form;


public class VendaForm {

	private Long carroId;
	
	private Long usuarioId;
	
	private Double valorTotal;
	
	private Boolean vendaCompleta;

	public Long getCarroId() {
		return carroId;
	}

	public void setCarroId(Long carro) {
		this.carroId = carro;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuario) {
		this.usuarioId = usuario;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Boolean getVendaCompleta() {
		return vendaCompleta;
	}

	public void setVendaCompleta(Boolean vendaCompleta) {
		this.vendaCompleta = vendaCompleta;
	}
}
