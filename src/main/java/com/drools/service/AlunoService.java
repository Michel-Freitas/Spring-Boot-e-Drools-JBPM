package com.drools.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drools.model.AlunoModel;

@Service
public class AlunoService {
	
	@Autowired
	KieContainer myKieContainer;
	
	public void calcularMedia(AlunoModel aluno) {
		
		double media = (aluno.getAv1() + aluno.getAv2() + aluno.getAv3()) / 3;
		aluno.setMediaAluno(media);
		
		KieSession mySession = myKieContainer.newKieSession("statusMediaAluno");
		mySession.insert(aluno);
		mySession.fireAllRules();
		mySession.dispose();
	}
}
