package com.example.mercadinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mercadinho.model.Produto;
import com.example.mercadinho.repository.produto.ProdutoRepositoryQuery;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoRepositoryQuery{

}
