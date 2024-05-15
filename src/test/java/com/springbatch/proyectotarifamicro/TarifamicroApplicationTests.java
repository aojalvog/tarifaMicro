package com.springbatch.proyectotarifamicro;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.springbatch.proyectotarifamicro.model.Productos;
import com.springbatch.proyectotarifamicro.service.ProductosService;

@SpringBootTest
class TarifamicroApplicationTests {

	// Mocks
	private ProductosService productosService;

	@BeforeEach
	void SetUp() {

		productosService = mock(ProductosService.class);
	}

	@Test
	void contextLoads() {
		when(productosService.getCatalogo()).thenReturn((List<Productos>) Datos.PRODUCTO1);
		when(productosService.getCatalogo()).thenReturn((List<Productos>) Datos.PRODUCTO2);

		// Productos producto1 = productosService.getCatalogo();

	}

}
