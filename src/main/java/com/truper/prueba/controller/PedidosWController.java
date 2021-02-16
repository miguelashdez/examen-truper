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

import com.truper.prueba.model.entity.PedidosW;
import com.truper.prueba.service.PedidosWService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosWController {

	@Autowired
	private PedidosWService service;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id) {
		PedidosW pedidosW = service.findById(id);
		if (pedidosW == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pedidosW);
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody PedidosW pedidosW) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(pedidosW));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody PedidosW pedidosW, @PathVariable Long id) {
		PedidosW pedidoActual = this.service.findById(id);
		if (pedidoActual == null) {
			return ResponseEntity.noContent().build();
		}
		pedidoActual.setTotal(pedidosW.getTotal());
		pedidoActual.setDateSale(pedidosW.getDateSale());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(pedidoActual));
	}

}