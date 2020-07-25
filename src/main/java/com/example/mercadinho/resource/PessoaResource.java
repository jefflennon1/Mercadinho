package com.example.mercadinho.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mercadinho.model.Pessoa;
import com.example.mercadinho.repository.PessoaRepository;
import com.example.mercadinho.repository.filter.PessoaFilter;
import com.example.mercadinho.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public Page<Pessoa> listar(PessoaFilter pessoaFilter, Pageable pageable){		
		return pessoaRepository.filtrar(pessoaFilter, pageable);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Pessoa> buscarPessoa(@PathVariable Long id){
		Pessoa pessoa = pessoaService.buscarPeloId(id);
		return ResponseEntity.ok(pessoa);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long id,@RequestBody Pessoa pessoa){
		Pessoa pessoaAtualiza = pessoaService.atualiza(id,pessoa);
		return ResponseEntity.ok(pessoaAtualiza);
	}
	
	@PutMapping("/{id}/telefone")
	public ResponseEntity<Pessoa> atualizaTel(@PathVariable Long id, @RequestBody String telefone){
		Pessoa pessoa = pessoaService.atualizaTel(id,telefone);
		return ResponseEntity.ok(pessoa);
	}
}
