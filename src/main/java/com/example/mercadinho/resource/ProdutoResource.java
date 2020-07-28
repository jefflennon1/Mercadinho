package com.example.mercadinho.resource;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mercadinho.event.MercadinhoRecursoCriadoEvent;
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
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public Page<Produto> pesquisar(ProdutoFilter produtoFilter, Pageable pageable){
		return produtoRepository.filtrar(produtoFilter, pageable);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPeloId(@PathVariable Long id){
		Produto produto = produtoService.BuscarPeloId(id);
		return ResponseEntity.ok().body(produto);
	}
	
	@PostMapping
	public ResponseEntity<Produto> salvar(@RequestBody Produto produto, HttpServletResponse response){
		Produto produtosalvo = produtoService.salvar(produto);
		publisher.publishEvent(new MercadinhoRecursoCriadoEvent(this, response,produtosalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(produto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Produto> deletar(@PathVariable Long id){
		produtoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto){
		Produto produtoAtualiza = produtoService.atualizar(id, produto);
		return ResponseEntity.ok(produtoAtualiza);
	}
	
	@PutMapping("/{id}/valor")
	public ResponseEntity<Produto> atualizaValor(@PathVariable Long id, @RequestBody BigDecimal produto){
		Produto produtoAtualizaValor = produtoService.atualizaValor(id, produto);
		return ResponseEntity.ok(produtoAtualizaValor);
	}
	
	@PutMapping("/{id}/validade")
	public ResponseEntity<Produto> atualizaValidade(@PathVariable Long  id, @RequestBody LocalDate validade){
		Produto atualizaValidade = produtoService.atualizaValidade(id,validade);
		return ResponseEntity.ok(atualizaValidade);
	}		
}
