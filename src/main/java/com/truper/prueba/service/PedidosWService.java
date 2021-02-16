package com.truper.prueba.service;

import java.util.List;

import com.truper.prueba.model.entity.PedidosW;

public interface PedidosWService {

	List<PedidosW> findAll();

	PedidosW findById(Long id);

	PedidosW save(PedidosW pedidosW);

	void deleteById(Long id);

}