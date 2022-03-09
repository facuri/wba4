package com.produtos.apirestwba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirestwba.model.DataDTO;
import com.produtos.apirestwba.model.Operacao;
import com.produtos.apirestwba.model.Titulo;
import com.produtos.apirestwba.repository.OperacaoRepository;
import com.produtos.apirestwba.service.OperacaoService;

@RestController
@RequestMapping(value = "/operacao")
public class OperacaoController {
	
	//@Autowired
	//private OperacaoRepository operacaoRepository;
	
	@Autowired
	private OperacaoService operacaoService;
	
	@GetMapping("/listaOp")
	public List<Operacao>list(){
		
		return operacaoService.listtAll();
	}
	
	 
	@GetMapping("/listaOperId/{id}")
	public Operacao get(@PathVariable Long id) {
		  
	   return operacaoService.getOp(id);
		  
	  }
	@PostMapping("/salvarOpr")
	public Operacao add(@RequestBody Operacao operacao, Titulo titulo) {
		
		return operacaoService.saveOp(operacao, titulo);
		
	}
	@PutMapping("/atualizarOpr")
	public Operacao updateOp(@RequestBody Operacao operacao, Titulo titulo) {
		
		 return operacaoService.updateOp(operacao, titulo);
		
	}
	@DeleteMapping("/deletarOpr/{id}")
	public void deletar(@PathVariable Long id) {
		
		operacaoService.deleteOp(id);
	}
	
	
	 
	
	 
	  

}
