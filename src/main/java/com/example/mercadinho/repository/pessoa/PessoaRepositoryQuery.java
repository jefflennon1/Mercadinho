package com.example.mercadinho.repository.pessoa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.mercadinho.model.Pessoa;
import com.example.mercadinho.repository.filter.PessoaFilter;

public interface PessoaRepositoryQuery  {

	public Page<Pessoa> filtrar(PessoaFilter pessoaFilter, Pageable pageable);
}
