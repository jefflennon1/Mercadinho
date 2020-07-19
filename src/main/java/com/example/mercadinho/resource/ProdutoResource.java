package com.example.mercadinho.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mercadinho.model.Produto;
import com.example.mercadinho.repository.ProdutoRepository;
import com.example.mercadinho.repository.filter.ProdutoFilter;
import com.example.mercadinho.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	
	@GetMapping
	public Page<Produto> pesquisar(ProdutoFilter produtoFilter, Pageable pageable){
		return produtoRepository.filtrar(produtoFilter, pageable);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPeloId(@PathVariable Long id){
		Produto produto = produtoService.BuscarPeloId(id);
		return ResponseEntity.ok().body(produto);
	}
}
