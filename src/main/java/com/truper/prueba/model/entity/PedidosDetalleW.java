package com.truper.prueba.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pedidos_detalle_w")
public class PedidosDetalleW implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String sku;

	private BigDecimal amount;

	private BigDecimal price;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido")
	private PedidosW pedidosW;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public PedidosW getPedidosW() {
		return pedidosW;
	}

	public void setPedidosW(PedidosW pedidosW) {
		this.pedidosW = pedidosW;
	}

	@Override
	public String toString() {
		return "PedidosDetalleW [id=" + id + ", sku=" + sku + ", amount=" + amount + ", price=" + price + ", pedidosW="
				+ pedidosW + "]";
	}

}