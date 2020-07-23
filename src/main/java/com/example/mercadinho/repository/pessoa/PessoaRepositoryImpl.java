package com.example.mercadinho.repository.pessoa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.example.mercadinho.model.Pessoa;
import com.example.mercadinho.repository.filter.PessoaFilter;

public class PessoaRepositoryImpl implements PessoaRepositoryQuery {
	
	@Autowired
	private EntityManager manager;

	@Override
	public Page<Pessoa> filtrar(PessoaFilter pessoaFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Pessoa> criteria = builder.createQuery(Pessoa.class);
		Root<Pessoa> root = criteria.from(Pessoa.class);
		
		Predicate[] predicates = adicionarRestricoes(pessoaFilter,builder, root );
		criteria.where(predicates);
		TypedQuery<Pessoa> query = manager.createQuery(criteria);
		adicionarPaginacao(query, pageable);
		return new PageImpl<Pessoa>(query.getResultList(), pageable, total(pessoaFilter));
	}

	private long total(PessoaFilter pessoaFilter) {
		
		return 0;
	}

	private void adicionarPaginacao(TypedQuery<Pessoa> query, Pageable pageable) {
		// TODO Auto-generated method stub
		
	}

	private Predicate[] adicionarRestricoes(PessoaFilter pessoaFilter, CriteriaBuilder builder, Root<Pessoa> root) {
		// TODO Auto-generated method stub
		return null;
	}

}
