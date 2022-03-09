package com.produtos.apirestwba.model;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
 

import lombok.Getter;
import lombok.Setter;
 
@Getter
@Setter
public class DataDTO  implements Serializable{

	 private static final long serialVersionUID = 1L;
	 
	 private Long useridOperacao, useridTitulo;
	 private Date userdataOperacao, userdataVencimento;
	 private BigDecimal userPrazo;
	
	  public DataDTO(Operacao operacao, Titulo titulo) {
		  
		  Date dataOperacao = new Date();
		  LocalDate userDataOperacao = dataOperacao.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		  
		  Date dataVencimento = new Date();
		  LocalDate userDataVencimento = dataVencimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		  
		   this.useridOperacao = operacao.getId();
		   this.useridTitulo = titulo.getId();
		   this.userdataOperacao = operacao.getDataOperacao();
		   this.userdataVencimento = titulo.getDataVencimento();
		   this.userPrazo = titulo.getPrazo();
		   
		   long dias = ChronoUnit.DAYS.between(userDataOperacao, userDataVencimento);
		   
		    if(this.userdataVencimento.after(this.userdataOperacao)) {//Posterior ou depois da data da operação
			   
			   System.out.println("Boleto não vencido " + dias);
			  
		   }else {
			   
			   System.out.println("Urgente - Boleto vencido " + dias);
			   
		   }
		     
		      
		 }
	  
	    
	   
	   
	 
	 

}
