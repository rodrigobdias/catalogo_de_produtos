package br.com.desafio.catalogodeprodutos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.desafio.catalogodeprodutos.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Long>, JpaSpecificationExecutor<Products>{

	Page<Products> findByName(String name, Pageable paginacao);
	
}
