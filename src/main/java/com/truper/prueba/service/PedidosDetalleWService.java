package com.truper.prueba.service;

import java.util.List;

import com.truper.prueba.model.entity.PedidosDetalleW;

public interface PedidosDetalleWService {

	List<PedidosDetalleW> findAll();

	PedidosDetalleW findById(Long id);

	PedidosDetalleW save(PedidosDetalleW pedidosW);

	void deleteById(Long id);

}