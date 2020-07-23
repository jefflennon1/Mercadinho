package com.example.mercadinho.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mercadinho.model.Pessoa;
import com.example.mercadinho.repository.PessoaRepository;
import com.example.mercadinho.repository.filter.PessoaFilter;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	
	@GetMapping
	public Page<Pessoa> listar(PessoaFilter pessoaFilter, Pageable pageable){
			
		return pessoaRepository.filtrar(pessoaFilter, pageable);
	}
}
