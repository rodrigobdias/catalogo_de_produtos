package br.com.desafio.catalogodeprodutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.catalogodeprodutos.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Long>{

}
