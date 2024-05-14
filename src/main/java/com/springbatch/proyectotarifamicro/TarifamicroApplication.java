package com.springbatch.proyectotarifamicro;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springbatch.proyectotarifamicro.reader.Reader;

@SpringBootApplication
public class TarifamicroApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TarifamicroApplication.class, args);
		Reader reader = new Reader();
		reader.itemReader();
	}
}
