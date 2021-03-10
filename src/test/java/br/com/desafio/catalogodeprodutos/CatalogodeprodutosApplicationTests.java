package br.com.desafio.catalogodeprodutos;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CatalogodeprodutosApplicationTests {

	@Test
	public void contextLoads() {
		Assert.assertTrue(true);
	}

}
