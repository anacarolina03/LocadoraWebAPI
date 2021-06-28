package com.wipro.projeto.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.projeto.model.LocacaoEntity;
import com.wipro.projeto.model.LocadorEntity;

import java.util.List;

import java.util.Optional;

public interface LocadorRepository extends JpaRepository<LocadorEntity, Long> {
    Optional<LocadorEntity> findByEmail(String email);
    LocadorEntity findByCpf(String cpf);
    LocadorEntity findByCpfAndIdNot(String cpf, Long id);	 
	List <LocadorEntity> findByExcluido (Boolean excluido);
	LocadorEntity findByCpfAndExcluido(String cpf, boolean b);
}