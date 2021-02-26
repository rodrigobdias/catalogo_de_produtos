package br.com.desafio.catalogodeprodutos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.catalogodeprodutos.controller.dto.ProductsDto;
import br.com.desafio.catalogodeprodutos.model.Products;
import br.com.desafio.catalogodeprodutos.repository.ProductsRepository;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductsRepository productsRepository;
	
	@GetMapping
	public List<ProductsDto> list() {
		List<Products> products = productsRepository.findAll();

		return ProductsDto.convert(products);
		
	}
}
