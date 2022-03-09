package com.produtos.apirestwba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.produtos.apirestwba.model.Produto;

 

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query("select  p from Produto p where p.nome like %?1% ")
	List<Produto>findProdutoByName(String nome);

}
