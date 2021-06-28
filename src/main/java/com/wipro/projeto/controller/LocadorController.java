package com.wipro.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.projeto.exception.ExistingCpfException;
import com.wipro.projeto.model.FilmeEntity;
import com.wipro.projeto.model.LocadorEntity;
import com.wipro.projeto.service.LocadorService;

@RestController

public class LocadorController {

    private LocadorService locadorService;

    
    
    @Autowired
    public LocadorController(LocadorService locadorService){
        this.locadorService = locadorService;   
    }

    public LocadorController(){

    }

    @PostMapping("/api/locador")
    public ResponseEntity<LocadorEntity> cadastrar(@RequestBody LocadorEntity locacao) throws ExistingCpfException{
    	try {
    		locadorService.incluir(locacao);
    		return new ResponseEntity<LocadorEntity>( HttpStatus.CREATED);
    	}catch (Exception e){
    		return new
    		ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
    	
    	}
    }
    
    @GetMapping("/api/locador")
    public ResponseEntity<List<LocadorEntity>> listarTodos(){    	
    	return new ResponseEntity<List<LocadorEntity>>(locadorService.listarTodos(), HttpStatus.OK);
    }
    
    @GetMapping("/api/locador/{id}")
    public ResponseEntity<LocadorEntity> obter(@PathVariable Long id) {
    	return new ResponseEntity<LocadorEntity>(locadorService.obter(id), HttpStatus.OK);
    }    
    
    @PutMapping("/api/locador/{id}")
    public ResponseEntity<LocadorEntity> editar(@PathVariable Long id, @RequestBody LocadorEntity usuario) throws ExistingCpfException {
    	usuario.setId(id);
        usuario = locadorService.editar(usuario);
        return new ResponseEntity<LocadorEntity>(usuario, HttpStatus.OK);
    }
    
    @DeleteMapping("/api/locador/{id}")
    public ResponseEntity<LocadorEntity> deletar(@PathVariable Long id) {    		
        locadorService.deletar(id);
        return new ResponseEntity<LocadorEntity>(HttpStatus.OK);
    }
}