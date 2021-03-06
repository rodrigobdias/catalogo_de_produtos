package br.com.desafio.catalogodeprodutos.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.desafio.catalogodeprodutos.model.Products;

public class ProductsForm {

	@NotNull 
	@NotEmpty
	@Length(min = 1)
	private String name;
	
	@NotNull
	@NotEmpty 
	@Length(min = 3)
	private String description;
	
	@DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer = 6, fraction = 2)
	@NotNull
	private BigDecimal price;

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Products convert() {
		return new Products(name, description, price);
	}
	
	
}
