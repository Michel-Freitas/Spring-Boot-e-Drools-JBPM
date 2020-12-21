package com.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieContainerSessionsPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BasicDroolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicDroolsApplication.class, args);
	}
	
	@Bean
	public KieContainer myKieContainer() {
		KieServices ks = KieServices.get();
		KieContainer kc = ks.getKieClasspathContainer();
		
		return kc;
	}
	
	@Bean
	public KieContainerSessionsPool myPoolKie() {
		KieServices ks = KieServices.get();
		KieContainer kc = ks.getKieClasspathContainer();
		KieContainerSessionsPool pool = kc.newKieSessionsPool(2);
		
		return pool;
	}
}
