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
	
	//// Validação do endpoint "POST /products"
	
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
		String json = "{\"name\":\"produto 1B\",\"description\":\"descrição do produto 1B\",\"price\":-12.98 }";
		
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
		String json = "{\"name\":\"\",\"description\":\"descrição do produto 1C\",\"price\":12.98 }";
		
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
		String json = "{\"name\":\"produto 1D\",\"\":85.6,\"price\":12.98 }";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(400));
	}	
	
	
//	//// Validação do endpoint "PUT /products/{id}"
//	
//	@Test
//	public void deveriaDevolver200ParaAtualizarUmProdutoBaseadoNoID() throws Exception {
//		URI uri = new URI("/products/1");
//		String json = "{\"name\":\"produto 1A\",\"description\":\"descrição do produto 1A\",\"price\":2.98 }";
//		
//		mockMvc
//		.perform(MockMvcRequestBuilders
//				.put(uri)
//				.content(json)
//				.contentType(MediaType.APPLICATION_JSON))
//		.andExpect(MockMvcResultMatchers
//				.status()
//				.is(200));
//	}	
	
	
	@Test
	public void deveriaDevolver404ParaAtualizarUmProdutoBaseadoNoIDNãoDisponivel() throws Exception {
		URI uri = new URI("/products/100");
		String json = "{\"name\":\"produto 1A\",\"description\":\"descrição do produto 1A\",\"price\":2.98 }";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.put(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(404));
	}		
	
	//// Validação do endpoint "GET /products/{id}"
	
	@Test
	public void deveriaDevolver200ParaLocalizarProdutoComID1() throws Exception {
		URI uri = new URI("/products/1");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	@Test
	public void deveriaDevolver404ParaIndicacarQueOProdutoNaoFoiLocalizado() throws Exception {
		URI uri = new URI("/products/199");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(404));
	}	
	
	//// Validação do endpoint "GET /products"
	
	@Test
	public void deveriaDevolver200IndicandoORetornoDosProdutosLocalizados() throws Exception {
		URI uri = new URI("/products");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	//// Validação do endpoint "GET /products/search"
	
	@Test
	public void deveriaDevolver200ParaBuscaDeProdutosFiltradosPorMin_pricMax_priceEQ() throws Exception {
		URI uri = new URI("/products/search?min_price=5.5&max_price=50&q=1A");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	@Test
	public void deveriaDevolver200ParaBuscaDeProdutosFiltradosPorQ() throws Exception {
		URI uri = new URI("/products/search?q=1A");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	@Test
	public void deveriaDevolver200ParaBuscaDeProdutosSemFiltro() throws Exception {
		URI uri = new URI("/products/search");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.get(uri))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	
	//// Validação do endpoint "DELETE /products/{id}"
	
	@Test
	public void deveriaDevolver404ParaDeletarUmProdutoNaoExistente() throws Exception {
		URI uri = new URI("/products/65");
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.delete(uri))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(404));
	}
	
}
