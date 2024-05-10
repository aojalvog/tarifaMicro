package com.springbatch.proyectotarifamicro.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springbatch.proyectotarifamicro.model.Productos;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class Reader {

	private List<Productos> readCsv(String filePath) throws IOException {
		List<Productos> productosList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(";");
				Productos producto = new Productos();
				if (fields.length == 7) {
					producto.setId(Long.parseLong(fields[0].trim()));
					producto.setLugar(fields[1].trim());
					producto.setStock(Integer.parseInt(fields[2].trim()));
					producto.setStockReal(Integer.parseInt(fields[3].trim()));
					producto.setStockVirtual(Integer.parseInt(fields[4].trim()));
					producto.setCodigo(Long.parseLong(fields[5].trim()));
					producto.setNombre(fields[6].trim());

					producto.setCodigo(Long.parseLong(fields[3].trim()));
					producto.setNombre(fields[0].trim());
					productosList.add(producto);
					log.info("El archivo CSV ha sido leído con éxito.");
				}

				else {
					log.error("Error: Número de campos incorrecto en la línea: " + line);
				}
			}
		}
		return productosList;
	}

}
