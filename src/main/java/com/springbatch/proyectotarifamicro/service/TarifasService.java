package com.springbatch.proyectotarifamicro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbatch.proyectotarifamicro.model.Tarifas;

@Service
public interface TarifasService {

	List<Tarifas> catalogo();

}
