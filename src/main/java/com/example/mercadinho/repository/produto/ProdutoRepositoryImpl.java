package com.example.mercadinho.repository.produto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.example.mercadinho.model.Produto;
import com.example.mercadinho.model.Produto_;
import com.example.mercadinho.repository.filter.ProdutoFilter;

public class ProdutoRepositoryImpl implements ProdutoRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Produto> filtrar(ProdutoFilter produtoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Produto> criteria = builder.createQuery(Produto.class);
		Root<Produto> root = criteria.from(Produto.class);
		
		Predicate[] predicates = criarRestricoes(produtoFilter, builder, root);
		criteria.where(predicates);
			
		TypedQuery<Produto> query = manager.createQuery(criteria);
		adicionarPaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(produtoFilter));
		}

	

	private Predicate[] criarRestricoes(ProdutoFilter produtoFilter, CriteriaBuilder builder, Root<Produto> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(produtoFilter.getNome())) {
			predicates.add(builder.like(builder.lower(root.get(Produto_.nome)),
					"%"+produtoFilter.getNome().toLowerCase()+"%"));
		}
		if(!StringUtils.isEmpty(produtoFilter.getDescricao())) {
			predicates.add(builder.like(builder.lower(root.get(Produto_.descricao)),
					"%"+produtoFilter.getDescricao().toLowerCase()+"%"));
		}
		
		if(!StringUtils.isEmpty(produtoFilter.getValorMaiorQue())) {
			predicates.add(builder.greaterThanOrEqualTo(root.get(Produto_.valor),
					produtoFilter.getValorMaiorQue()));
		}
		
		if(!StringUtils.isEmpty(produtoFilter.getValorMenorQue())) {
			predicates.add(builder.lessThanOrEqualTo(root.get(Produto_.valor),
					produtoFilter.getValorMenorQue()));
		}
		
		if(!StringUtils.isEmpty(produtoFilter.getValidadeMaiorQue())) {
			predicates.add(builder.greaterThanOrEqualTo(root.get(Produto_.validade),
					produtoFilter.getValidadeMaiorQue()));
		}
		if(!StringUtils.isEmpty(produtoFilter.getValidadeMenorQue())) {
			predicates.add(builder.lessThanOrEqualTo(root.get(Produto_.validade),
					produtoFilter.getValidadeMenorQue()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private Long total(ProdutoFilter produtoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Produto> root = criteria.from(Produto.class);
		
		Predicate[] predicates = criarRestricoes(produtoFilter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void adicionarPaginacao(TypedQuery<Produto> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int registrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * registrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(registrosPorPagina);
	}

}
