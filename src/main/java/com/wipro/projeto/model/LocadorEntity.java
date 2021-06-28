package com.wipro.projeto.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class LocadorEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String sexo;
    @Email(message="E-Mail inválido")
    private String email;   
    @NotNull(message = " Data de nascimento é obrigatória")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nascimento;
    private String naturalidade;
    private String nacionalidade;
    @CPF(message="Cpf Inválido")
    @NotNull(message = " CPF é obrigatório")
    private String cpf;
    private Boolean excluido;
  
    public LocadorEntity ()
    {}


    public LocadorEntity(Long id, String nome, String sexo, String email, Date nascimento, String naturalidade, String nacionalidade, String cpf, Boolean excluido){
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;        
        this.nascimento = nascimento;
        this.naturalidade = naturalidade;
        this.naturalidade = nacionalidade;
        this.cpf = cpf;
        this.excluido = excluido;
    }

    public LocadorEntity(String nome, String sexo, String email, Date nascimento, String naturalidade, String nacionalidade, String cpf, Boolean excluido){
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;        
        this.nascimento = nascimento;
        this.naturalidade = naturalidade;
        this.naturalidade = nacionalidade;
        this.cpf = cpf;
        this.excluido = excluido;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Boolean getExcluido() {
		return excluido;
	}

	public void setExcluido(Boolean excluido) {
		this.excluido = excluido;
	}

}
