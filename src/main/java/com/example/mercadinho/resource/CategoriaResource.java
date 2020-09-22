package com.example.mercadinho.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mercadinho.model.Categoria;
import com.example.mercadinho.repository.CategoriaRepository;
import com.example.mercadinho.repository.filter.CategoriaFilter;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	@GetMapping
	public List<Categoria> todosFiltrado(CategoriaFilter categoriaFilter, Pageable pageable){
		return categoriaRepository.filtrar(pageable, categoriaFilter);
	}
}
