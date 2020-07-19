package com.example.mercadinho.repository.produto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.mercadinho.model.Produto;
import com.example.mercadinho.repository.filter.ProdutoFilter;

public interface ProdutoRepositoryQuery {

	Page<Produto> filtrar(ProdutoFilter produtoFilter, Pageable pageable);
}
