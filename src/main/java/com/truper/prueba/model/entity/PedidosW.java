package com.truper.prueba.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos_w")
public class PedidosW implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal total;

	@Column(name = "date_sale")
	private Date dateSale;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Date getDateSale() {
		return dateSale;
	}

	public void setDateSale(Date dateSale) {
		this.dateSale = dateSale;
	}

	@Override
	public String toString() {
		return "PedidosW [id=" + id + ", total=" + total + ", dateSale=" + dateSale + "]";
	}

}