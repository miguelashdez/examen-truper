package com.truper.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truper.prueba.model.entity.PedidosDetalleW;
import com.truper.prueba.service.PedidosDetalleWService;

@RestController
@RequestMapping("/api/detalle")
public class PedidosDetalleWController {

	@Autowired
	private PedidosDetalleWService service;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		PedidosDetalleW pedidosDetalleW = service.findById(id);
		if (pedidosDetalleW == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pedidosDetalleW);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody PedidosDetalleW pedidosDetalleW) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(pedidosDetalleW));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody PedidosDetalleW pedidosDetalleW, @PathVariable Long id) {
		PedidosDetalleW detalleActual = this.service.findById(id);
		if (detalleActual == null) {
			return ResponseEntity.noContent().build();
		}
		detalleActual.setSku(pedidosDetalleW.getSku());
		detalleActual.setAmount(pedidosDetalleW.getAmount());
		detalleActual.setPrice(pedidosDetalleW.getPrice());
		detalleActual.setPedidosW(pedidosDetalleW.getPedidosW());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(detalleActual));
	}

}