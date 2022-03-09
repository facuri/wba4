package com.produtos.apirestwba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.apirestwba.model.Produto;
import com.produtos.apirestwba.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	 public List<Produto>getListProutosByNome(String nome){
		 
		 List<Produto> produtos = produtoRepository.findProdutoByName(nome);
		 
		 return produtos;
		 
	 }
	
	 
	

}
