package com.springbatch.proyectotarifamicro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Tarifas {
	// Esto es para el CSV
	private Long id;
	private String nombre;
	private Double precio;

}
