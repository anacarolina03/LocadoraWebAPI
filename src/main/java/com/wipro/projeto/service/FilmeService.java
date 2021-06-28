package com.wipro.projeto.service;



import com.wipro.projeto.exception.ExistingCpfException;
import com.wipro.projeto.exception.ExistingFilmeIndisponivelException;
import com.wipro.projeto.model.FilmeEntity;
import com.wipro.projeto.model.LocacaoEntity;
import com.wipro.projeto.model.LocadorEntity;
import com.wipro.projeto.repository.FilmeRepository;
import com.wipro.projeto.repository.LocadorRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {

   
	private FilmeRepository filmeRepository;
	private FilmeEntity filme;
    

    @Autowired
    public FilmeService(FilmeRepository filmeRepository){
        this.filmeRepository = filmeRepository;
      
    }

    public FilmeEntity incluir(FilmeEntity filme) throws ExistingFilmeIndisponivelException  {   
    	if (filme.getQuant().intValue() <=0) {
    	throw new ExistingFilmeIndisponivelException("Filme Indisponível");
    	}
    	filme.setExcluido(false);    
    	return filmeRepository.save(filme);
    	}
    
    
    public List<FilmeEntity> listarTodos(){
        return filmeRepository.findByExcluido(false);
    }  
    
    
    
    public FilmeEntity obter(Long id) {
        return filmeRepository.findById(id).get();
    }

 
    
    public FilmeEntity editar(FilmeEntity filme) throws ExistingFilmeIndisponivelException {
    	/*if (filme.getQuant() <= 0) {
        	throw new ExistingFilmeIndisponivelException("Filme Indisponível");
        	}*/
        filme.setExcluido(false);
        return filmeRepository.save(filme);
		   }
    
 
    public void deletar (Long id) {
    	FilmeEntity filme = filmeRepository.findById(id).get();
    	filme.setExcluido(true);
        filmeRepository.save(filme);
		
    }

}
