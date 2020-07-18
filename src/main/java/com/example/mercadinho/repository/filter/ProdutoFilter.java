package com.example.mercadinho.repository.filter;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ProdutoFilter {

	private String descricao;
	private String nome;
	
	
	private BigDecimal valorMaiorQue;		
	private BigDecimal valorMenorQue;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate validadeMenorQue;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate validadeMaiorQue;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorMaiorQue() {
		return valorMaiorQue;
	}

	public void setValorMaiorQue(BigDecimal valorMaiorQue) {
		this.valorMaiorQue = valorMaiorQue;
	}

	public BigDecimal getValorMenorQue() {
		return valorMenorQue;
	}

	public void setValorMenorQue(BigDecimal valorMenorQue) {
		this.valorMenorQue = valorMenorQue;
	}

	public LocalDate getValidadeMenorQue() {
		return validadeMenorQue;
	}

	public void setValidadeMenorQue(LocalDate validadeMenorQue) {
		this.validadeMenorQue = validadeMenorQue;
	}

	public LocalDate getValidadeMaiorQue() {
		return validadeMaiorQue;
	}

	public void setValidadeMaiorQue(LocalDate validadeMaiorQue) {
		this.validadeMaiorQue = validadeMaiorQue;
	}
	
	
	
	
	
}
