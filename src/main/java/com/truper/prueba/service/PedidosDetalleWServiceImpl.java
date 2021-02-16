package com.truper.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.truper.prueba.model.PedidosDetalleWRepository;
import com.truper.prueba.model.entity.PedidosDetalleW;

@Service
public class PedidosDetalleWServiceImpl implements PedidosDetalleWService {

	@Autowired
	private PedidosDetalleWRepository repository;

	@Override
	public List<PedidosDetalleW> findAll() {
		return (List<PedidosDetalleW>) repository.findAll();
	}

	@Override
	public PedidosDetalleW findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public PedidosDetalleW save(PedidosDetalleW pedidosW) {
		return repository.save(pedidosW);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
