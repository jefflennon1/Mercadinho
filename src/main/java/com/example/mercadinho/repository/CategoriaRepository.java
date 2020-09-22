package com.example.mercadinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mercadinho.model.Categoria;
import com.example.mercadinho.repository.categoria.CategoriaRepositoryQuery;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>, CategoriaRepositoryQuery{

}
