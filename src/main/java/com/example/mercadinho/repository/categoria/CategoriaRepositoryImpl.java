package com.example.mercadinho.repository.categoria;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.mercadinho.model.Categoria;
import com.example.mercadinho.repository.filter.CategoriaFilter;

public class CategoriaRepositoryImpl implements CategoriaRepositoryQuery{

	@Override
	public Page<Categoria> filtrar(Pageable pageable, CategoriaFilter categoriaFilter) {
		// TODO Auto-generated method stub
		return null;
	}

}
