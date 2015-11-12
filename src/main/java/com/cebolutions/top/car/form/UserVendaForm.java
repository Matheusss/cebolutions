package com.cebolutions.top.car.form;

import java.util.Date;

import com.cebolutions.top.car.entity.User;

public class UserVendaForm {

	private Long id;
	
/*	private Long numeroCartao;
	
	private Date dtCartao;*/
		
	public UserVendaForm(User user){
		this.id = user.getId();
/*		this.numeroCartao = user.getNumeroCartao();
		this.dtCartao = user.getDtCartao();*/
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*public Long getNumeroCartao() {
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
	}*/
	
}
