package com.springbatch.proyectotarifamicro.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbatch.proyectotarifamicro.model.Productos;
import com.springbatch.proyectotarifamicro.service.ProductosService;

@RestController
// @RequestMapping("/api")
public class ProductosController {

	@Autowired
	ProductosService productosService;

	@GetMapping("/getCatalogo")
	public ResponseEntity<List<Productos>> findAll() {
		return ResponseEntity.ok(productosService.getCatalogo());
	}

	@PostMapping("/postCatalogo")
	public Optional<List<Productos>> postCatalogo(@RequestBody List<Productos> productos) throws IOException {

		return productosService.saveCatalogo(productos);
	}

}
