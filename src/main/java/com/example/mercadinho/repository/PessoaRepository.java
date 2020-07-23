package com.example.mercadinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mercadinho.model.Pessoa;
import com.example.mercadinho.repository.pessoa.PessoaRepositoryQuery;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, PessoaRepositoryQuery {

}
