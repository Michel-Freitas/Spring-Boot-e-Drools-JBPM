package com.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
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
}
