package com.systempro.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systempro.cursomc.domain.Pedido;
import com.systempro.cursomc.domain.Cliente;
import com.systempro.cursomc.repositories.PedidoRepository;
import com.systempro.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido buscar(Integer id) {

		Optional<Pedido> obj = repo.findById(id);

		if (obj == null) {

			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName());
		}
		return obj.orElse(null);
	}

}
