package com.example.mercadinho.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mercadinho.model.Pessoa;
import com.example.mercadinho.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	
	@GetMapping
	public List<Pessoa> listar(){
			
		return pessoaRepository.findAll() ;
	}
}
