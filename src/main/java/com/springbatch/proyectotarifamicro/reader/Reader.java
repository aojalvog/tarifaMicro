package com.springbatch.proyectotarifamicro.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.springbatch.proyectotarifamicro.maps.Maps;
import com.springbatch.proyectotarifamicro.model.Tarifas;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Data

public class Reader {

	/**
	 * Método para leer el CSV
	 * 
	 * @return Mapa {@link Maps} de Tarifas {@link Tarifas} lleno.
	 * @throws IOException
	 */

	public Map<Long, Tarifas> itemReader() throws IOException {

		// Ruta absoluta del archivo que se va a leer.
		String filePath = "outputTarifas.csv";

		// Se crea un buffer que lee el fichero.
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			String line;
			int contador = 0;
			log.info("El archivo CSV se está leyendo...");
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(";");
				// Se crea un objeto de Tarifa al que se le setean los valores que se encuentran
				// en el CSV y después se le añaden al mapa.
				Tarifas tarifa = new Tarifas();
				if (fields.length == 4) {

					tarifa.setId(Long.parseLong(fields[0].trim()));
					tarifa.setNombre(fields[1]);
					tarifa.setPrecio(Double.parseDouble(fields[2].trim()));
					tarifa.setIva(Double.parseDouble(fields[3].trim()));

					Maps.getTarifas().put(tarifa.getId(), tarifa);
					contador++;
					String isEmpty;

					// log para comprobar si el mapa se rellena correctamente
					if (Maps.getTarifas().isEmpty()) {
						isEmpty = "VACÍO";
					} else {
						isEmpty = "LLENO";
					}
					log.info(isEmpty);
				}

				else {
					log.error("Error: Número de campos incorrecto en la línea: " + line);
				}
			}

			log.info("Se han añadido " + contador + " TARIFAS.");
		}
		return Maps.getTarifas();
	}
}
