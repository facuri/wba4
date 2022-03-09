package com.produtos.apirestwba.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("deprecation")
@Getter
@Setter
@Entity
@Table(name = "TB_Titulo")
public class Titulo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal valor;
    
    @DateTimeFormat(pattern = "yyy-MM-dd")
	@Temporal(TemporalType.DATE)
    private Date dataVencimento;
    private BigDecimal prazo;
     @JsonIgnore//Evita recursão
	@org.hibernate.annotations.ForeignKey(name = "operacao_id")
	   @ManyToOne(optional = false)//cadatro obrigatório Classe Pai
    // @ManyToOne
    private Operacao operacao;
    
	
	

}
