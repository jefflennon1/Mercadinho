package com.example.mercadinho.repository.produto;

import java.util.List;

import com.example.mercadinho.model.Produto;
import com.example.mercadinho.repository.filter.ProdutoFilter;

public interface ProdutoRepositoryQuery {

	List<Produto> filtrar(ProdutoFilter produtoFilter);
}
