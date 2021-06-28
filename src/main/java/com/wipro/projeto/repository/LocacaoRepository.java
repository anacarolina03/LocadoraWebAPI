package com.wipro.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.projeto.model.FilmeEntity;
import com.wipro.projeto.model.LocacaoEntity;

import java.util.List;

public interface LocacaoRepository extends JpaRepository<LocacaoEntity, Long> {
    
	Optional<LocacaoEntity> findById(Long id);
	List <LocacaoEntity> findByExcluido (Boolean excluido);
    
}
