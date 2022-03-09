package com.produtos.apirestwba.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperacaoDTO implements Serializable  {

	 private static final long serialVersionUID = 1L;
	 
	 private Long useridOperacao, useridTitulo;
	 private BigDecimal userValorTotal, userValor;
	 
	  
	public OperacaoDTO(Operacao operacao, Titulo titulo) {
		 
		   this.useridOperacao = operacao.getId();
		   this.useridTitulo = titulo.getId();
		   this.userValorTotal = operacao.getValorTotal();
		   this.userValor = titulo.getValor();
		   //Soma dos campos
		   this.setUserValorTotal(this.getUserValorTotal().add(this.getUserValor()));
		   
		} 
	
	
	 
	 

}
