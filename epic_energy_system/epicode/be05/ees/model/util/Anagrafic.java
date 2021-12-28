package it.epicode.be05.ees.model.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.epicode.be05.ees.model.entity.Commune;
import it.epicode.be05.ees.model.entity.Province;
import it.epicode.be05.ees.service.interfaces.CommuneService;
import it.epicode.be05.ees.service.interfaces.ProvinceService;

//CLASSE PER LA GESTIONE PERSISTENZA DEI COMUNI E PROVINCE DA CSV
@Component
public class Anagrafic {

	@Autowired
	CommuneService communeService;

	@Autowired
	ProvinceService provinceService;

	public void readFile() throws IOException {

		String line = "";

		@SuppressWarnings("resource")
		BufferedReader provinceReader = new BufferedReader(
				new FileReader("src/main/resources/static/province-italiane-1.csv"));

		String nextLine = "";

		@SuppressWarnings("resource")
		BufferedReader commonReader = new BufferedReader(
				new FileReader("src/main/resources/static/comuni-italiani-1.csv"));

		while ((line = provinceReader.readLine()) != null) {

			String[] position = line.split(";");

			var province = Province.build().setAbbr(position[0]).setName(position[1]);

			provinceService.create(province);

		}

		
		while ((nextLine = commonReader.readLine()) != null) {
			
			String[] position2 = nextLine.split(";");
			var common = Commune.build().setCommune(position2[2]).setProvince(provinceService.findByName(position2[3]));
			communeService.create(common);
		}

	}

	
}
