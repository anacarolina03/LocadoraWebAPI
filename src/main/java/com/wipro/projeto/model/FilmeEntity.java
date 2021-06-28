package com.wipro.projeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class FilmeEntity {

    @Id
    @GeneratedValue
    private Long id;
    
    @NotNull(message = " Título é obrigatório") 
    private String titulo;      
    private String genero;
    private Integer quant;    
    private Double valor;
    private Boolean excluido;


    public FilmeEntity ()
    {}

    public FilmeEntity(Long id, String titulo, String genero, Integer quant, Double valor, Boolean excluido){
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.quant = quant;
        this.valor = valor;   
        this.excluido = excluido;
    }

     public FilmeEntity(String titulo, String genero, Integer quant, Double valor, Boolean excluido){
    	 this.titulo = titulo;
         this.genero = genero;
         this.quant = quant;
         this.valor = valor;  
         this.excluido = excluido;
    } 
    
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getQuant() {
		return quant;
	}

	public void setQuant(Integer quant) {
		this.quant = quant;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Boolean getExcluido() {
		return excluido;
	}

	public void setExcluido(Boolean excluido) {
		this.excluido = excluido;
	}

}