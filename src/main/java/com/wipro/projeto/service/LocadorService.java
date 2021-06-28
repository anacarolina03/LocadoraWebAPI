package com.wipro.projeto.service;


import java.util.List;
import java.util.Optional;

import javax.xml.crypto.Data;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wipro.projeto.exception.ExistingCpfException;
import com.wipro.projeto.model.LocacaoEntity;
import com.wipro.projeto.model.LocadorEntity;
import com.wipro.projeto.repository.LocadorRepository;



@Service
public class LocadorService {

   
	private LocadorRepository locadorRepository;
	
    

    @Autowired
    public LocadorService(LocadorRepository locadorRepository) {
    	this.locadorRepository = locadorRepository;
      
    }
    
  

    public LocadorEntity incluir(LocadorEntity locador) throws ExistingCpfException  {   
		LocadorEntity locado = locadorRepository.findByCpfAndExcluido(locador.getCpf(),false);
    	if (locado != null) {
    	throw new ExistingCpfException("Locador existente");
    	} 
    	locador.setExcluido(false);
    	return locadorRepository.save(locador);
    	}
    
    
    public List<LocadorEntity> listarTodos(){    	
    	return locadorRepository.findByExcluido(false);       
    }  
    
    
    public LocadorEntity obter(Long id) {
        return locadorRepository.findById(id).get();
    }
    
    
    public LocadorEntity editar(LocadorEntity locador) throws ExistingCpfException {    	
    /*if (locador.getId() != null && !locador.getId().equals(0L)) {
             LocadorEntity locado = locadorRepository.findByCpfAndIdNot(locador.getCpf(), locador.getId());
             if (locador != null) {
             throw new ExistingCpfException("CPF existente");
             }
    	 } */
        locador.setExcluido(false);
        return locadorRepository.save(locador);
		   }
    
    
 
    public void deletar (Long id) {
    	LocadorEntity locador = locadorRepository.findById(id).get();
    	locador.setExcluido(true);
        locadorRepository.save(locador);
		
    }

}