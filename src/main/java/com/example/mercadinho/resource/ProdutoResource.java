package com.example.mercadinho.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Produto> pesquisar(ProdutoFilter produtoFilter){
		return produtoRepository.filtrar(produtoFilter);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPeloId(@PathVariable Long id){
		Produto produto = produtoService.BuscarPeloId(id);
		return ResponseEntity.ok().body(produto);
	}
}
