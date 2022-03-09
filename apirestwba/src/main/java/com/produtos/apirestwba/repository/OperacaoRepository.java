package com.produtos.apirestwba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirestwba.model.Operacao;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {

}
