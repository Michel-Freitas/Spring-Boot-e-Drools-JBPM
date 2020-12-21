package com.drools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drools.service.PessoaService;

@RestController
@RequestMapping(value="/BasicDrools")
public class GeralController {
	
	@Autowired
	PessoaService servicePessoa;
	

	@GetMapping("/idade/{idade}")
	public void idadeAcesso(@PathVariable int idade) {
		servicePessoa.verificaIdadePermitida(idade);
	}
}
