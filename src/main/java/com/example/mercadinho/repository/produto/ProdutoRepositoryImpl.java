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

import com.example.mercadinho.model.Produto;
import com.example.mercadinho.repository.filter.ProdutoFilter;

public class ProdutoRepositoryImpl implements ProdutoRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Produto> filtrar(ProdutoFilter produtoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Produto> criteria = builder.createQuery(Produto.class);
		Root<Produto> root = criteria.from(Produto.class);

		
		Predicate[] predicates = criarRestricoes(produtoFilter, builder, root);
		criteria.where(predicates);
		
		
		TypedQuery<Produto> query = manager.createQuery(criteria);
		return query.getResultList();
		}

	private Predicate[] criarRestricoes(ProdutoFilter produtoFilter, CriteriaBuilder builder, Root<Produto> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
