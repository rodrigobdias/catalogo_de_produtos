package br.com.desafio.catalogodeprodutos.repository;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.desafio.catalogodeprodutos.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {

	Page<Products> findByName(String name, Pageable paginacao);

	@Query("SELECT t FROM Products t WHERE (:q is null or t.name = :q) or "
			+ "(:q is null or t.description like %:q%) and "
			+ "(:min_price is null or t.price >= :min_price) and "
			+ "(:max_price is null or t.price <= :max_price)")
	Page<Products> findProductsByNameAndDescriptionAndPrice(@Param("q") String q, 
			@Param("min_price") BigDecimal min_price, 
			@Param("max_price") BigDecimal max_price, 
			Pageable paginacao);	
	


}
