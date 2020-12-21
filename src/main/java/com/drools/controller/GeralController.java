package com.drools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drools.model.AlunoModel;
import com.drools.service.AlunoService;
import com.drools.service.PessoaService;

@RestController
@RequestMapping(value="/BasicDrools")
public class GeralController {
	
	@Autowired
	PessoaService servicePessoa;
	
	@Autowired
	AlunoService serviceAluno;
	

	@GetMapping("/idade/{idade}")
	public void idadeAcesso(@PathVariable int idade) {
		servicePessoa.verificaIdadePermitida(idade);
	}
	
	@PostMapping("/aluno")
	public String statusAvaliacaoAluno(@RequestBody AlunoModel aluno) {
		serviceAluno.calcularMedia(aluno);
		
		return aluno.getNomeAluno() + " " + aluno.getStatusAluno();
		
	}
}
