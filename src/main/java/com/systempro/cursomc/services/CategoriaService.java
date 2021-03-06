package com.systempro.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systempro.cursomc.domain.Categoria;
import com.systempro.cursomc.domain.Cliente;
import com.systempro.cursomc.repositories.CategoriaRepository;
import com.systempro.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		
		if(obj == null) {
					
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: "+ Cliente.class.getName());
		}
		return obj.orElse(null);
	}

}
