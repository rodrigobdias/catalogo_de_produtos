package br.com.desafio.catalogodeprodutos.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafio.catalogodeprodutos.controller.dto.DetailsProductDto;
import br.com.desafio.catalogodeprodutos.controller.dto.ProductsDto;
import br.com.desafio.catalogodeprodutos.controller.form.ProductsForm;
import br.com.desafio.catalogodeprodutos.controller.form.UpdateProductsForm;
import br.com.desafio.catalogodeprodutos.model.Products;
import br.com.desafio.catalogodeprodutos.repository.ProductsRepository;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductsRepository productsRepository;
	
	@GetMapping
	@Cacheable(value = "listProducts")
	public Page<ProductsDto> list(@RequestParam(required = false) String name, 
			@PageableDefault(sort = "id",  direction = Direction.ASC) Pageable pagination) {
		
		if (name == null) {
			Page<Products> products = productsRepository.findAll(pagination);
			return ProductsDto.convert(products);
		} else {
			Page<Products> products = productsRepository.findByName(name, pagination);
			return ProductsDto.convert(products);
		}		
	}
	

	
//	@GetMapping("/search")
//	@Cacheable(value = "listProducts")
//	public Page<ProductsDto> listSearch(@RequestParam(required = false) String q,
//			                            @RequestParam(required = false) BigDecimal min_price,
//			                            @RequestParam(required = false) BigDecimal max_price) {
//		
//		Page<Products> products = productsRepository.findAll(???);
//
//		return ProductsDto.convert(products);
//		
//	}	
	
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listProducts", allEntries = true)
	public ResponseEntity<ProductsDto> register(@RequestBody @Valid ProductsForm productsForm, UriComponentsBuilder uriBuilder) {
		
		Products products = productsForm.convert();
		productsRepository.save(products);
		
		URI uri = uriBuilder.path("/products/{id}").buildAndExpand(products.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProductsDto(products));
	}	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<DetailsProductDto> detail(@PathVariable Long id) {
		Optional<Products> products = productsRepository.findById(id);
		
		if(products.isPresent()) {
			return ResponseEntity.ok(new DetailsProductDto(products.get()));			
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listProducts", allEntries = true)
	public ResponseEntity<ProductsDto> update(@PathVariable Long id, @RequestBody @Valid UpdateProductsForm updateProductsForm) {
		Optional<Products> optional = productsRepository.findById(id);
		
		if(optional.isPresent()) {
			Products products = updateProductsForm.update(id, productsRepository);
			
			return ResponseEntity.ok(new ProductsDto(products));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listProducts", allEntries = true)
	public ResponseEntity<?> remove(@PathVariable Long id){
		
		Optional<Products> optional = productsRepository.findById(id);
		
		if(optional.isPresent()) {
			productsRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
}
