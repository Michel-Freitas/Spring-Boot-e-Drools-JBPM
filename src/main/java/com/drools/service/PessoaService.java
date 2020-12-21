package com.drools.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drools.model.PessoaModel;

@Service
public class PessoaService {
	
	@Autowired
	KieContainer myKieContainer;

	public void verificaIdadePermitida(int idade) {
		PessoaModel pessoa = new PessoaModel();
		pessoa.setIdade(idade);
		
		KieSession mySession = myKieContainer.newKieSession("idadePermitida");
		mySession.insert(pessoa);
		mySession.fireAllRules();
		mySession.dispose();
	}
}
