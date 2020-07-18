package com.example.mercadinho.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mercadinho.model.Produto;
import com.example.mercadinho.repository.ProdutoRepository;
import com.example.mercadinho.repository.filter.ProdutoFilter;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@GetMapping
	public List<Produto> pesquisar(ProdutoFilter produtoFilter){
		return produtoRepository.filtrar(produtoFilter);
	}
}
