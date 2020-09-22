package com.example.mercadinho.repository.categoria;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.mercadinho.model.Categoria;
import com.example.mercadinho.repository.filter.CategoriaFilter;

public interface CategoriaRepositoryQuery {

	public List<Categoria> filtrar(Pageable pageable, CategoriaFilter categoriaFilter);
}
