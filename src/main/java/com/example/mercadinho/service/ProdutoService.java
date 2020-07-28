package com.example.mercadinho.service;

import java.math.BigDecimal;
import java.time.LocalDate;

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

	public Produto salvar(Produto produto) {
		Produto produtoSalvo = produtoRepository.save(produto);
		return produtoSalvo;
	}

	public void deletar(Long id) {
		Produto produtoDeleta = BuscarPeloId(id);
		produtoRepository.delete(produtoDeleta);
	}

	public Produto atualizar(Long id, Produto produto) {
		Produto produtoAtualiza = BuscarPeloId(id);
		produtoAtualiza = produtoRepository.save(produto);
		
		return produtoAtualiza;
	}

	public Produto atualizaValor(Long id, BigDecimal produto) {
		Produto produtoBusca = BuscarPeloId(id);
		produtoBusca.setValor(produto);
		
		return produtoRepository.save(produtoBusca);
	}

	public Produto atualizaValidade(Long id, LocalDate validade) {
		Produto produto = BuscarPeloId(id);
		produto.setValidade(validade);
		return produtoRepository.save(produto);
	}

}
