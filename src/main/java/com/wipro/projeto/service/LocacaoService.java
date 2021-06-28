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



import com.wipro.projeto.exception.ExistingFilmeIndisponivelException;

import com.wipro.projeto.model.LocacaoEntity;
import com.wipro.projeto.model.LocadorEntity;
import com.wipro.projeto.model.FilmeEntity;
import com.wipro.projeto.repository.LocacaoRepository;
import com.wipro.projeto.repository.FilmeRepository;

@Service
public class LocacaoService {

   
	private LocacaoRepository locacaoRepository;
	
    

    @Autowired
    public LocacaoService(LocacaoRepository locacaoRepository){
        this.locacaoRepository = locacaoRepository;
      
    }
    
  

    public LocacaoEntity incluir(LocacaoEntity locacao)  {    	
    	locacao.setExcluido(false);    	
    	return locacaoRepository.save(locacao);
    	}
    
    
    public List<LocacaoEntity> listarTodos(){
    	return locacaoRepository.findByExcluido(false);
    }  
    
    public LocacaoEntity obter(Long id) {
        return locacaoRepository.findById(id).get();
    }

    
    
    public LocacaoEntity editar(LocacaoEntity locacao) {
    	if (locacao.getEntrega().after(locacao.getDevolucao()));
    	{
        System.out.print("Atraso na Devolução");
        }
        locacao.setExcluido(false);
        return locacaoRepository.save(locacao);
		   }
    
 
    public void deletar (Long id) {
    	LocacaoEntity locacao = locacaoRepository.findById(id).get();
    	locacao.setExcluido(true);
        locacaoRepository.save(locacao);
		
    }

}