package com.springbatch.proyectotarifamicro.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springbatch.proyectotarifamicro.model.Productos;

@Service

public interface ProductosService {

	// Métodos GET

	List<Productos> getCatalogo();

	Optional<Productos> getProductoById(Productos producto);

	// Métodos POST

	Optional<List<Productos>> saveCatalogo(List<Productos> producto) throws IOException;

}
