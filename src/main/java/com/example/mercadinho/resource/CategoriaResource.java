package com.example.mercadinho.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mercadinho.model.Categoria;
import com.example.mercadinho.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<Categoria> todos(){
		return categoriaRepository.findAll();
	}
}
