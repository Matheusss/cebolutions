package com.cebolutions.top.car.form;

import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.cebolutions.top.car.json.LocalDateJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class VendaForm {

	private Long carroId;
	
	private Long usuarioId;
	
	private Double valorTotal;
	
	private Boolean vendaCompleta;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@JsonDeserialize(using = LocalDateJsonDeserializer.class)
	private LocalDate data;

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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
}
