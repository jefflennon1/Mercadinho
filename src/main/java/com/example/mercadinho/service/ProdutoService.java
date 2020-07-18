package com.example.mercadinho.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.mercadinho.model.Produto;
import com.example.mercadinho.repository.ProdutoRepository;
import com.example.mercadinho.service.exception.RecursoNaoExisteException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto BuscarPeloId(Long id) {
		Produto produtoExistente = produtoRepository.findOne(id);
		if(StringUtils.isEmpty(produtoExistente)) {
			throw new RecursoNaoExisteException();			
		} 
		
		
		return produtoExistente;
	}


}
