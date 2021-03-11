package br.com.desafio.catalogodeprodutos.controller;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ProductsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void deveriaDevolver201CasoOsDadosDeCadastroDoProdutoEstejamCorretos() throws Exception {
		URI uri = new URI("/products");
		String json = "{\"name\":\"produto 1A\",\"description\":\"descrição do produto 1A\",\"price\":12.98 }";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(201));
	}
	
	@Test
	public void deveriaDevolver400ParaOCasoDoCadastroDoProdutoComPrecoInvalido() throws Exception {
		URI uri = new URI("/products");
		String json = "{\"name\":\"produto 1A\",\"description\":\"descrição do produto 1A\",\"price\":-12.98 }";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400));
	}
	
	@Test
	public void deveriaDevolver400ParaOCasoDoCadastroDoProdutoComNameInvalido() throws Exception {
		URI uri = new URI("/products");
		String json = "{\"name\":\"\",\"description\":\"descrição do produto 1A\",\"price\":12.98 }";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400));
	}	

	@Test
	public void deveriaDevolver400ParaOCasoDoCadastroDoProdutoComDescriptionInvalido() throws Exception {
		URI uri = new URI("/products");
		String json = "{\"name\":\"produto 1A\",\"\":85.6,\"price\":12.98 }";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400));
	}	
	
	
	@Test
	public void deveriaAtualizarUmProdutoBaseadoNoIDEDevolver200() throws Exception {
		URI uri = new URI("/products/1");
		String json = "{\"name\":\"produto 1A\",\"description\":\"descrição do produto 1A\",\"price\":2.98 }";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.put(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}	
	
	
}
