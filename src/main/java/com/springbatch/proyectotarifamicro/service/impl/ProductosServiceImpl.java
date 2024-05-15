package com.springbatch.proyectotarifamicro.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springbatch.proyectotarifamicro.maps.Maps;
import com.springbatch.proyectotarifamicro.model.Productos;
import com.springbatch.proyectotarifamicro.reader.Reader;
import com.springbatch.proyectotarifamicro.service.ProductosService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductosServiceImpl implements ProductosService {

	private Reader reader;

	public ProductosServiceImpl(Reader reader) {
		this.reader = reader;
	}

	/**
	 * Método que recorre el mapa de catálogo y devuelve los valores pasándolos a
	 * una lista.
	 */
	@Override
	public List<Productos> getCatalogo() {

		log.info("----ACCEDIENDO AL CATÁLOGO----");

		return Maps.getCatalogo().values().stream().toList();
	}

	/**
	 * Método {@link Optional} que guarda los productos {@link Productos}. Comprueba
	 * si el id de la tarifa existe en algún producto y, si existe, le asigna el
	 * precio y el nombre de la tarifa
	 */
	@Override
	public Optional<List<Productos>> saveCatalogo(List<Productos> productos) throws IOException {
		log.info("----GUARDANDO EL PRODUCTO----");

		for (int i = 0; i < productos.size(); i++) {

			if (Optional.ofNullable(Maps.getTarifas().get(productos.get(i).getId())).isPresent()) {

				productos.get(i).setNombreTarifa(Maps.getTarifas().get(productos.get(i).getId()).getNombre());

				// Cálculo del IVA para seterarlo a los productos
				double precio = Maps.getTarifas().get(productos.get(i).getId()).getPrecio();
				double iva = Maps.getTarifas().get(productos.get(i).getId()).getIva();
				double precioConIva = precio * (1 + (iva / 100));
				productos.get(i).setPrecio(precioConIva);

				Maps.getCatalogo().put(productos.get(i).getId(), productos.get(i));

			}

		}

		log.info("----" + Maps.getCatalogo().size() + " PRODUCTOS GUARDADOS----");
		return Optional.of(productos);
	}

}
