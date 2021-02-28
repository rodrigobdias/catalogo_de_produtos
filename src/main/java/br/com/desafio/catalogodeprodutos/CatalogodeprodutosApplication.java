package br.com.desafio.catalogodeprodutos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CatalogodeprodutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogodeprodutosApplication.class, args);
	}

}
