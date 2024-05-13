package com.springbatch.proyectotarifamicro.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbatch.proyectotarifamicro.model.Tarifas;
import com.springbatch.proyectotarifamicro.reader.Reader;
import com.springbatch.proyectotarifamicro.service.TarifasService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TarifasServiceImpl implements TarifasService {

	@Autowired
	private Reader reader;

	@Override
	public List<Tarifas> catalogo() {
		try {

			return reader.readCsvFiles();

		} catch (IOException e) {

			e.printStackTrace();
			log.error("Lectura del archivo CSV incorrecta");
			return null;
		}
	}
}
