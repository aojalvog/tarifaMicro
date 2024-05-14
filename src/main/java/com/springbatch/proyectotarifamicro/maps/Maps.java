package com.springbatch.proyectotarifamicro.maps;

import java.util.HashMap;
import java.util.Map;

import com.springbatch.proyectotarifamicro.model.Productos;
import com.springbatch.proyectotarifamicro.model.Tarifas;

/**
 * Clase en la que se van a almacenar los mapas para después utilizarlos más
 * fácilmente
 */
public class Maps {

	/**
	 * Constructor por defecto de la clase Maps
	 * 
	 */

	private Maps() {

	}

	/**
	 * Creación de los mapas que vamos a utilizar.
	 */
	private static Map<Long, Tarifas> mapaTarifas = new HashMap<>();
	private static Map<Long, Productos> mapaProductos = new HashMap<>();

	/**
	 * Método para añadir una tarifa al mapa.
	 * 
	 * @param id     se le asigna el id del producto de la clase {@link Productos}
	 * @param tarifa Objeto de la clase {@link Tarifas}.
	 */
	public static void addTarifa(Long id, Tarifas tarifa) {
		mapaTarifas.put(id, tarifa);
	}

	/**
	 * Método GET para retornar el mapa de Tarifas
	 * 
	 * @return mapa de {@link Tarifas}
	 */
	public static Map<Long, Tarifas> getTarifas() {
		return mapaTarifas;
	}

	/**
	 * Método para añadir productos {@link Productos} al catálogo.
	 * 
	 * @param id       se añade el id del producto.
	 * @param producto que vamos a añadir
	 */

	public static void addCatalogo(Long id, Productos producto) {
		mapaProductos.put(producto.getId(), producto);
	}

	/**
	 * Método GET para devolver el mapa de los productos
	 * 
	 * @return mapaProductos.
	 */

	public static Map<Long, Productos> getCatalogo() {
		return mapaProductos;
	}

	/**
	 * Método GET que devuelve un producto introduciendo un ID
	 * 
	 * @param id ID del producto que queremos consultar
	 * @return producto al que corresponde ese id
	 */
	public static Productos getProductoById(Long id) {
		return mapaProductos.get(id);
	}

}
