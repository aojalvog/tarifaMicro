package com.springbatch.proyectotarifamicro.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbatch.proyectotarifamicro.maps.Maps;
import com.springbatch.proyectotarifamicro.model.Productos;
import com.springbatch.proyectotarifamicro.reader.Reader;
import com.springbatch.proyectotarifamicro.service.ProductosService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductosServiceImpl implements ProductosService {

	@Autowired
	Reader reader;

	/**
	 * Método que recorre el mapa de catálogo y devuelve los valores pasándolos a
	 * una lista.
	 */
	@Override
	public List<Productos> getCatalogo() {

		return Maps.getCatalogo().values().stream().toList();
	}

	@Override
	public Optional<Productos> getProductoById(Productos producto) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	/**
	 * Método {@link Optional} que guarda los productos {@link Productos}. Comprueba
	 * si el id de la tarifa existe en algún producto y, si existe, le asigna el
	 * precio y el nombre de la tarifa
	 */
	@Override
	public Optional<List<Productos>> saveCatalogo(List<Productos> productos) throws IOException {
		log.info("Entrando en saveCatalogo");

		for (int i = 0; i < productos.size(); i++) {

			if (Optional.ofNullable(Maps.getTarifas().get(productos.get(i).getId())).isPresent()) {

				productos.get(i).setNombreTarifa(Maps.getTarifas().get(productos.get(i).getId()).getNombre());
				productos.get(i).setPrecio(Maps.getTarifas().get(productos.get(i).getId()).getPrecio());

				Maps.getCatalogo().put(productos.get(i).getId(), productos.get(i));

			}

		}

		return Optional.of(productos);
	}

}
