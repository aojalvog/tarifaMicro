package com.springbatch.proyectotarifamicro;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.springbatch.proyectotarifamicro.controller.ProductosController;
import com.springbatch.proyectotarifamicro.model.Productos;
import com.springbatch.proyectotarifamicro.service.ProductosService;

@WebMvcTest(controllers = ProductosController.class)
class TestCatalogo {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	ProductosService productosService;

	List<Productos> listProductos;

	@BeforeEach
	void init() {

		listProductos = new ArrayList<>();
		listProductos.add(new Productos(1L, "Cáceres", 5, 2, 3, "iPhone", "básica", 9.99));
	}

	@Test
	void postCatalogoTest() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post("/postCatalogo").contentType("application/json")
				.content(new Gson().toJson(listProductos)).characterEncoding("utf-8")).andExpect(status().isOk())
				.andReturn();

	}

	@Test
	void findAllTest() throws Exception {

		ResultActions resultActions = mockMvc.perform(get("/getCatalogo"));

		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(0)));
	}

}
