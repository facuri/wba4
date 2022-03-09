package com.produtos.apirestwba.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

 @Getter
 @Setter
@Entity
@Table(name = "TB_OPERACAO")
public class Operacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 private BigDecimal valorTotal, listaDeTitulos;
	 
	  @DateTimeFormat(pattern = "yyy-MM-dd")
	 @Temporal(TemporalType.DATE)
	 private Date dataOperacao;
	 
	 @OneToMany(mappedBy="operacao", orphanRemoval = true, cascade = CascadeType.ALL)
	 private List<Titulo> titulos = new ArrayList<Titulo>();
	 
	 
	public List<Titulo> getTitulos() {
		return titulos;
	}
	
	 public void setTitulos(List<Titulo> titulos) {
		this.titulos = titulos;
	}
	 
	 @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operacao other = (Operacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	 
	 

}
