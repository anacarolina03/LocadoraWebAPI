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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.projeto.exception.ExistingFilmeIndisponivelException;
import com.wipro.projeto.model.FilmeEntity;
import com.wipro.projeto.model.LocadorEntity;
import com.wipro.projeto.service.FilmeService;



@RestController
public class FilmeController {

    private FilmeService filmeService;

    
    
    @Autowired
    public FilmeController(FilmeService filmeService){
        this.filmeService = filmeService;   
    }

    public FilmeController(){

    }

    @PostMapping("/api/filme")
    public ResponseEntity<FilmeEntity> cadastrar(@RequestBody FilmeEntity filme) throws ExistingFilmeIndisponivelException{
      try {  FilmeEntity film = filmeService.incluir(filme);
        return  new ResponseEntity<FilmeEntity>( HttpStatus.CREATED);
    }catch (Exception e){
		return new
		ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
	
	}
}
    
    
    @GetMapping("/api/filme")
    public ResponseEntity<List<FilmeEntity>> listarTodos(){    	
    	return new ResponseEntity<List<FilmeEntity>>(filmeService.listarTodos(), HttpStatus.OK);
    }
    
    @GetMapping("/api/filme/{id}")
    public ResponseEntity<FilmeEntity> obter(@PathVariable Long id) {    	
    	return new ResponseEntity<FilmeEntity>(filmeService.obter(id), HttpStatus.OK);
    }    
    
    @PutMapping("/api/filme/{id}")
    public ResponseEntity<FilmeEntity> editar(@PathVariable Long id, @RequestBody FilmeEntity usuario) throws ExistingFilmeIndisponivelException {
    	usuario.setId(id);
        usuario = filmeService.editar(usuario);
        return new ResponseEntity<FilmeEntity>(usuario, HttpStatus.OK);
    }
 
    
    @DeleteMapping("/api/filme/{id}")
    public ResponseEntity<FilmeEntity> deletar(@PathVariable Long id) {    	
        filmeService.deletar(id);
        return new ResponseEntity<FilmeEntity>(HttpStatus.OK);
    }
}
