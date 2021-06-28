package com.wipro.projeto.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.projeto.model.FilmeEntity;


import java.util.List;


public interface FilmeRepository extends JpaRepository<FilmeEntity, Long> {
    
	Optional<FilmeEntity> findById(Long id);
    List <FilmeEntity> findByExcluido (Boolean excluido);
    
}