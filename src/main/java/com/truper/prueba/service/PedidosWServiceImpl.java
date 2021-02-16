package com.truper.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truper.prueba.model.PedidosWRepository;
import com.truper.prueba.model.entity.PedidosW;

@Service
public class PedidosWServiceImpl implements PedidosWService {

	@Autowired
	private PedidosWRepository repository;

	@Override
	public List<PedidosW> findAll() {
		return (List<PedidosW>) repository.findAll();
	}

	@Override
	public PedidosW findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public PedidosW save(PedidosW pedidosW) {
		return repository.save(pedidosW);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}