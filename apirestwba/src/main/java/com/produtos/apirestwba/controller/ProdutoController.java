package com.produtos.apirestwba.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.hibernate.type.descriptor.java.PrimitiveCharacterArrayTypeDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import com.produtos.apirestwba.model.OperacaoDTO;
import com.produtos.apirestwba.model.Produto;
import com.produtos.apirestwba.model.Titulo;
//import com.produtos.apirestwba.model.TituloDTO;
import com.produtos.apirestwba.repository.OperacaoRepository;
import com.produtos.apirestwba.repository.ProdutoRepository;
import com.produtos.apirestwba.repository.TituloRepository;

 

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
	
	private static final int TituloDTO = 0;
	
    private Operacao a1 = new Operacao();
    private Titulo a2 = new Titulo();
    
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private OperacaoRepository operacaoRepository;
	
	@Autowired
	private TituloRepository tituloRepository;
	
	//Todos itens da lista
	@GetMapping(value = "/")
	public List<Produto> listaCompleta(){
		
		return(List<Produto>)produtoRepository.findAll();
	}
	
	//Lista pelo ID
	@GetMapping(value = "/{id}")
	public Optional<Produto> listaId(@PathVariable(value = "id") Long id){
		
		return produtoRepository.findById(id);
	}
	
	//Salvar
	@PostMapping(value = "/")
	public Produto salvar(@RequestBody Produto produto) {
		
		return produtoRepository.save(produto);
		
	}
	//Atualizar
	@PutMapping(value = "/")
	public Produto atualizar(@RequestBody Produto produto) {
		
		return produtoRepository.save(produto);
		
	}
	//Deletar
	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable("id") Long id) {
		
		  produtoRepository.deleteById(id);
		
	}
     
	//Todos itens da lista Operacao
	@GetMapping(value = "/listOper")
	public List<Operacao> listaCompletaOper(){
		
		return(List<Operacao>)operacaoRepository.findAll();
	}
	 
	 // Lista operacao pelo id Operacao
	@GetMapping(value = "listOperId/{id}", produces = "application/json")
	 public ResponseEntity<Operacao> listaOperacaoId(@PathVariable(value = "id") Long id) {
		
		 Optional<Operacao> operacao =  operacaoRepository.findById(id);
		
		 return new ResponseEntity<Operacao>(operacao.get(), HttpStatus.OK) ;
	     
		  
	}
	  
	   //Salvar Operacao
		@PostMapping(value = "/salvarOp")
		public Operacao salvarOperacao(@RequestBody Operacao operacao) {
			  
			for(int pos = 0; pos < operacao.getTitulos().size(); pos++) {
				operacao.getTitulos().get(pos).setOperacao(operacao);
			}
			return operacaoRepository.save(operacao);
			
		}
		
		//Atualizar Operacao
		@PutMapping(value = "/atualizarOp")
		public Operacao atualizarOperacao(@RequestBody Operacao operacao) {
			
			for(int pos = 0; pos < operacao.getTitulos().size(); pos++) {
				operacao.getTitulos().get(pos).setOperacao(operacao);
				
			}
			
			return operacaoRepository.save(operacao);
			
		}
		
		//Deletar Operacao
		@DeleteMapping(value = "/deletarOp/{id}")
		 public void deletarOp(@PathVariable("id") Long id) {
					
			 operacaoRepository.deleteById(id);
					
				}
		
		  //OperacaoDTO
		 @GetMapping(value = "/pegarDTO/{id}/idTitulo/{idTi}", produces = "application/json")
          public ResponseEntity<OperacaoDTO>initDTO(@PathVariable Long id, @PathVariable Long idTi){
        	  
        	  Optional<Operacao> operacao = operacaoRepository.findById(id);
        	  
        	  Optional<Titulo> titulo = tituloRepository.findById(idTi);
        	  
        	  return new ResponseEntity<OperacaoDTO>(new OperacaoDTO(operacao.get(), titulo.get()), HttpStatus.OK);
          }
		 
		 //DataDTO
		 @GetMapping(value = "/dataDTO/{id}/idTitulo/{idTi}", produces = "application/json")
          public ResponseEntity<DataDTO>dataDTO(@PathVariable Long id, @PathVariable Long idTi){
        	  
        	  Optional<Operacao> operacao = operacaoRepository.findById(id);
        	  
        	  Optional<Titulo> titulo = tituloRepository.findById(idTi);
        	  
        	  return new ResponseEntity<DataDTO>(new DataDTO(operacao.get(), titulo.get()), HttpStatus.OK);
          }
		 
		   //Salvar Operacao Soma
			@PostMapping(value = "/salvarOpSom")
			public Operacao salvarOperacaoS(@RequestBody Operacao operacao, Titulo titulo) {
				  BigDecimal soma;
				for(int pos = 0; pos < operacao.getTitulos().size(); pos++) {
					operacao.getTitulos().get(pos).setOperacao(operacao);
					 if(operacao.getValorTotal() != null && titulo.getValor() != null)  
					     //this.setValorTotal(this.getValorTotal().add(this.getValor()));
					     operacao.setValorTotal(operacao.getValorTotal().add(titulo.getValor()));
				}
				return operacaoRepository.save(operacao);

		 }	 
		  
		 
		
	 

}
