package com.springbatch.proyectotarifamicro.maps;

import java.util.HashMap;
import java.util.Map;

import com.springbatch.proyectotarifamicro.model.Productos;
import com.springbatch.proyectotarifamicro.model.Tarifas;

public class Maps {

	private Maps() {

	}

	private static Map<Long, Tarifas> mapaTarifas = new HashMap<>();
	private static Map<Long, Productos> mapaProductos = new HashMap<>();

	public static void addTarifa(Long id, Tarifas tarifa) {
		mapaTarifas.put(id, tarifa);
	}

	public static Map<Long, Tarifas> getTarifas() {
		return mapaTarifas;
	}

	public static void addCatalogo(Long id, Productos producto) {
		mapaProductos.put(producto.getId(), producto);
	}

	public static Map<Long, Productos> getCatalogo() {
		return mapaProductos;
	}

	public static Productos getProductoById(Long id) {
		return mapaProductos.get(id);
	}

}
