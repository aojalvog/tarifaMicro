package com.springbatch.proyectotarifamicro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Productos {

	// Esto es para el Json final
	private Long id;
	private String lugar;
	private Integer stock;
	private Integer stockReal;
	private Integer stockVirtual;
	private String nombre;
	private String nombreTarifa;
	private Double precio;

}
