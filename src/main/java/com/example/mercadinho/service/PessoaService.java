package com.example.mercadinho.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.mercadinho.model.Pessoa;
import com.example.mercadinho.repository.PessoaRepository;
import com.example.mercadinho.service.exception.RecursoNaoExisteException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa buscarPeloId(Long id) {
		Pessoa pessoa = pessoaRepository.findOne(id);
		if(StringUtils.isEmpty(pessoa)) {
			throw new RecursoNaoExisteException();
		}
		return pessoa;
	}

	public Pessoa atualiza(Long id, Pessoa pessoa) {
		Pessoa pessoaAtt = buscarPeloId(id);
		pessoaAtt = pessoaRepository.save(pessoa);
		return pessoaAtt;
	}

	public Pessoa atualizaTel(Long id, String telefone) {
		Pessoa pessoaTel = buscarPeloId(id);
		pessoaTel.setTelefone(telefone);
		
		return pessoaRepository.save(pessoaTel);
	}

}
