package com.springbatch.proyectotarifamicro.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springbatch.proyectotarifamicro.model.Tarifas;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class Reader {

	public List<Tarifas> readCsvFiles() throws IOException {
		List<Tarifas> tarifaList = new ArrayList<>();

		List<Tarifas> tarifasCsv = itemReader(
				"C:\\Users\\6003036\\Documents\\proyectos de Eclipse\\tarifamicro\\src\\main\\resources\\outputTarifas.csv");
		log.info("Ruta leída correctamente");

		for (int i = 0; i < tarifasCsv.size(); i++) {
			Tarifas tarifaCsv = tarifasCsv.get(i);

			Tarifas tarifas = new Tarifas();
			tarifas.setId(tarifaCsv.getId());
			tarifas.setNombre(tarifaCsv.getNombre());
			tarifas.setPrecio(tarifaCsv.getPrecio());

			tarifaList.add(tarifas);
		}

		return tarifaList;
	}

	private List<Tarifas> itemReader(String filePath) throws IOException {
		List<Tarifas> tarifasList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			int contador = 0;
			log.info("El archivo CSV se está leyendo...");
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(";");
				Tarifas tarifa = new Tarifas();
				if (fields.length == 3) {

					tarifa.setId(Long.parseLong(fields[0].trim()));
					tarifa.setNombre(fields[1]);
					tarifa.setPrecio(Double.parseDouble(fields[2].trim()));

					tarifasList.add(tarifa);
					contador++;
				}

				else {
					log.error("Error: Número de campos incorrecto en la línea: " + line);
				}
			}

			log.info("Se han añadido " + contador + " productos.");
		}
		return tarifasList;
	}

}
