package it.mybookingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.mybookingsystem.config.LanguageConfiguration;

@RestController
@RequestMapping("/info")
public class InformationController {

	@Autowired
	LanguageConfiguration config;

	@GetMapping("/language/{lang}")
	public ResponseEntity<String> getInformation(@PathVariable String lang){
		HttpHeaders headers = new HttpHeaders();
		headers.add("customHeader", "headervalue");
		String body;

		switch(lang) {
		
		case "ita": {body = config.textIta;
		break;}
		
		case "eng": {body = config.textEng;
		break;}

		default: body = "testo non disponibile per questa lingua";
		}
		
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(body, headers, HttpStatus.OK);
		return responseEntity;
	}
}
