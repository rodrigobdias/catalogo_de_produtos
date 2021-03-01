package br.com.desafio.catalogodeprodutos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@EnableSpringDataWebSupport
@EnableSwagger2
public class CatalogodeprodutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogodeprodutosApplication.class, args);
	}

}
