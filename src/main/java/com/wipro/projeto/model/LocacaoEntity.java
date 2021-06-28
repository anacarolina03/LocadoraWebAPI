package com.wipro.projeto.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class LocacaoEntity {
	
	@Id
    @GeneratedValue
    private Long id;
    
	@CPF(message="Cpf Inválido")
    @NotNull(message = " CPF é obrigatório")
    private String cpf;
    private String titulo; 
    private Integer quantFilme;  
    @NotNull(message = " Data de locacão é obrigatória")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date locacao;
    @NotNull(message = " Data de devolucao é obrigatória")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date devolucao;
    @NotNull(message = " Data de entrega é obrigatória")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entrega;
    private Double valor;
    private String situacao;
    private Boolean excluido;
    
    public LocacaoEntity ()
    {}

    public LocacaoEntity (Long id, String cpf, String titulo, Integer quantFilme, Date locacao, Date devolucao, Date entrega, Double valor, String situacao, Boolean excluido){
        this.id = id;           
        this.cpf = cpf;
        this.titulo = titulo;  
        this.quantFilme = quantFilme;
        this.locacao = locacao;
        this.devolucao = devolucao;
        this.entrega = entrega;
        this.valor = valor;  
        this.situacao = situacao; 
        this.excluido = excluido;
        
    }

    public 	LocacaoEntity (String cpf, String titulo, Integer quantFilme, Date locacao, Date devolucao, Date entrega, Double valor, String situacao, Boolean excluido){
    	this.id = id;           
        this.cpf = cpf;
        this.titulo = titulo;  
        this.quantFilme = quantFilme;
        this.locacao = locacao;
        this.devolucao = devolucao;
        this.entrega = entrega;
        this.valor = valor;  
        this.situacao = situacao; 
        this.excluido = excluido;
        
    }
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getQuantFilme() {
		return quantFilme;
	}

	public void setQuantFilme(Integer quantFilme) {
		this.quantFilme = quantFilme;
	}

	public Date getLocacao() {
		return locacao;
	}

	public void setLocacao(Date locacao) {
		this.locacao = locacao;
	}

	public Date getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Date devolucao) {
		this.devolucao = devolucao;
	}

	public Date getEntrega() {
		return entrega;
	}

	public void setEntrega(Date entrega) {
		this.entrega = entrega;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}


	public Boolean getExcluido() {
		return excluido;
	}

	public void setExcluido(Boolean excluido) {
		this.excluido = excluido;
	}
	  
    
}
