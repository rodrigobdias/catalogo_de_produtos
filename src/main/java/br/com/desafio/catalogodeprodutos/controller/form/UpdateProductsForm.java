package br.com.desafio.catalogodeprodutos.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.desafio.catalogodeprodutos.model.Products;
import br.com.desafio.catalogodeprodutos.repository.ProductsRepository;

public class UpdateProductsForm {

	@NotNull
	@NotEmpty
	private String name;
	
	@NotNull
	@NotEmpty
	private String description;
	
	@NotNull
	@NotEmpty
	private String price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Products update(Long id, ProductsRepository productsRepository) {
		Products products = productsRepository.getOne(id);
		
		products.setName(this.name);
		products.setDescription(this.description);
		products.setPrice(new BigDecimal(this.price));
		
		return products;
	}
	
	
}
