package br.com.desafio.catalogodeprodutos.controller.dto;

import java.math.BigDecimal;

import br.com.desafio.catalogodeprodutos.model.Products;

public class DetailsProductDto {

	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	
	public DetailsProductDto(Products products) {
		this.id = products.getId();
		this.name = products.getName();
		this.description = products.getDescription();
		this.price = products.getPrice();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
	
}
