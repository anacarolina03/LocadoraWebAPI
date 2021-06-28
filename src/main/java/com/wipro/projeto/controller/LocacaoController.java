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


import com.wipro.projeto.model.FilmeEntity;
import com.wipro.projeto.model.LocacaoEntity;
import com.wipro.projeto.model.LocadorEntity;
import com.wipro.projeto.service.FilmeService;
import com.wipro.projeto.service.LocacaoService;

@RestController

public class LocacaoController {

    private LocacaoService locacaoService;

    
    
    @Autowired
    public LocacaoController(LocacaoService locacaoService){
        this.locacaoService = locacaoService;   
    }

    public LocacaoController(){

    }

    @PostMapping("/api/locacao")
    public ResponseEntity<LocacaoEntity> cadastrar(@RequestBody LocacaoEntity locacao){
        LocacaoEntity locaca = locacaoService.incluir(locacao);
        return  new ResponseEntity<LocacaoEntity>( HttpStatus.CREATED);
    }
    
    @GetMapping("/api/locacao")
    public ResponseEntity<List<LocacaoEntity>> listarTodos(){
    	
    	return new ResponseEntity<List<LocacaoEntity>>(locacaoService.listarTodos(), HttpStatus.OK);
    }
    
    @GetMapping("/api/locacao/{id}")
    public ResponseEntity<LocacaoEntity> obter(@PathVariable Long id) {    	
    	return new ResponseEntity<LocacaoEntity>(locacaoService.obter(id), HttpStatus.OK);
    }    
    
    @PutMapping("/api/locacao/{id}")
    public ResponseEntity<LocacaoEntity> editar(@PathVariable Long id, @RequestBody LocacaoEntity usuario) {
    	usuario.setId(id);
        usuario = locacaoService.editar(usuario);
        return new ResponseEntity<LocacaoEntity>(usuario, HttpStatus.OK);
    }
    
    @DeleteMapping("/api/locacao/{id}")
    public ResponseEntity<LocacaoEntity> deletar(@PathVariable Long id) {    	   	
        locacaoService.deletar(id);
        return new ResponseEntity<LocacaoEntity>(HttpStatus.OK);
    }
}